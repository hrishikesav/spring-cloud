package com.hrishi.spring.empmanager.empmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrishi.spring.empmanager.empmanager.model.Employee;
import com.hrishi.spring.empmanager.empmanager.model.EmployeeHealthInsurance;
import com.hrishi.spring.empmanager.empmanager.service.EmployeeService;
import com.hrishi.spring.empmanager.empmanager.service.HealthInsuranceService;
import com.hrishi.spring.empmanager.empmanager.service.OrganizationService;

@Service
@Transactional
public class OrganzationServiceImpl implements OrganizationService {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	HealthInsuranceService healthInsuranceService;

	@Override
	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
		
		employeeService.insertEmployee(employee);
		if(employee.getEmpId().equalsIgnoreCase("E4")) {
			throw new RuntimeException("Testing transaction");
		}
		healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
	}

	@Override
	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
		
		employeeService.deleteEmployeeById(employee.getEmpId());
		healthInsuranceService.deleteEmployeeHealthInsuranceById(employeeHealthInsurance.getEmpId());
	}

}
