package com.hrishi.spring.empmanager.empmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrishi.spring.empmanager.empmanager.dao.EmployeeDao;
import com.hrishi.spring.empmanager.empmanager.model.Employee;
import com.hrishi.spring.empmanager.empmanager.service.EmployeeService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee employee) {
		
		employeeDao.insertEmployee(employee);
		
	}

	@Override
	public void insertEmployees(List<Employee> employees) {
		
		employeeDao.insertEmplotees(employees);
		
	}

	@Override
	public void getAllEmployees() {
		
		List<Employee> allEmployees = employeeDao.getAllEmployees();
		allEmployees.stream().forEach(System.out::println);
		
	}

	@Override
	public void getEmployeeById(String empId) {
		
		Employee employeeById = employeeDao.getEmployeeById(empId);
		System.out.println(employeeById);
		
	}

	@Override
	public void deleteEmployeeById(String empid) {
		employeeDao.deleteEmployeeById(empid);
	}

}
