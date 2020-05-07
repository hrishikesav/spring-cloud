package com.hrishi.spring.empmanager.empmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hrishi.spring.empmanager.empmanager.model.Employee;
import com.hrishi.spring.empmanager.empmanager.model.EmployeeHealthInsurance;
import com.hrishi.spring.empmanager.empmanager.service.OrganizationService;

@SpringBootApplication
public class EmployeeManagerApplication {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeeManagerApplication.class, args);
		
		OrganizationService organizationService = context.getBean(OrganizationService.class);
		
		Employee employee1 = new Employee();
		employee1.setEmpId("E1");
		employee1.setEmpName("Mike Ross");
		
		Employee employee2 = new Employee();
		employee2.setEmpId("E2");
		employee2.setEmpName("Harvey Specter");
		
		Employee employee3 = new Employee();
		employee3.setEmpId("E3");
		employee3.setEmpName("Louis Litt");
		
		
		EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId("E1");
		employeeHealthInsurance.setHealthInsuranceSchemeName("premium");
		employeeHealthInsurance.setCoverageAmount(20000);
		
		organizationService.joinOrganization(employee1, employeeHealthInsurance);
		
		System.out.println("The End");
		
	}

}
