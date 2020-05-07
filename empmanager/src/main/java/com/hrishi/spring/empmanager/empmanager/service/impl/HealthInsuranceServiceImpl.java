package com.hrishi.spring.empmanager.empmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrishi.spring.empmanager.empmanager.dao.HealthInsuranceDao;
import com.hrishi.spring.empmanager.empmanager.model.EmployeeHealthInsurance;
import com.hrishi.spring.empmanager.empmanager.service.HealthInsuranceService;

@Service
public class HealthInsuranceServiceImpl implements HealthInsuranceService {
	
	@Autowired
	HealthInsuranceDao healthInsuranceDao;

	@Override
	public void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance) {
		healthInsuranceDao.registerEmployeeHealthInsurance(employeeHealthInsurance);
	}

	@Override
	public void deleteEmployeeHealthInsuranceById(String empId) {
		healthInsuranceDao.deleteEmployeeHealthInsuranceById(empId);
	}

}
