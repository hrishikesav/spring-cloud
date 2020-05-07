package com.hrishi.spring.empmanager.empmanager.service;

import com.hrishi.spring.empmanager.empmanager.model.Employee;
import com.hrishi.spring.empmanager.empmanager.model.EmployeeHealthInsurance;

public interface OrganizationService {

	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance);

	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance);

}
