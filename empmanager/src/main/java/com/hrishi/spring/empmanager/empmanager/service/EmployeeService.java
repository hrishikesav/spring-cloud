package com.hrishi.spring.empmanager.empmanager.service;

import java.util.List;

import com.hrishi.spring.empmanager.empmanager.model.Employee;

public interface EmployeeService {
	
	void insertEmployee(Employee employee);
	void insertEmployees(List<Employee> employees);
	void getAllEmployees();
	void getEmployeeById(String empId);
	void deleteEmployeeById(String empid);

}
