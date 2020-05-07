package com.hrishi.spring.empmanager.empmanager.dao;

import java.util.List;

import com.hrishi.spring.empmanager.empmanager.model.Employee;

public interface EmployeeDao {
	
	void insertEmployee(Employee employee);
	void insertEmplotees(List<Employee> employees);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(String empId);
	void deleteEmployeeById(String empId);
	
}
