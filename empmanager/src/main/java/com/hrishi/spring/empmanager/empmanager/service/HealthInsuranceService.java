package com.hrishi.spring.empmanager.empmanager.service;

import com.hrishi.spring.empmanager.empmanager.model.EmployeeHealthInsurance;

public interface HealthInsuranceService {
	
	void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance);
	void deleteEmployeeHealthInsuranceById(String empId);

}
