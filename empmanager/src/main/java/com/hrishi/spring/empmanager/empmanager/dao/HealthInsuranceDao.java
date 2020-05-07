package com.hrishi.spring.empmanager.empmanager.dao;

import com.hrishi.spring.empmanager.empmanager.model.EmployeeHealthInsurance;

public interface HealthInsuranceDao {
	
	void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance);
	void deleteEmployeeHealthInsuranceById(String empId);

}
