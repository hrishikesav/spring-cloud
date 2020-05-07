package com.hrishi.spring.empmanager.empmanager.dao.impl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrishi.spring.empmanager.empmanager.dao.HealthInsuranceDao;
import com.hrishi.spring.empmanager.empmanager.model.EmployeeHealthInsurance;

@Repository
public class HealthInsuranceDaoImpl extends JdbcDaoSupport implements HealthInsuranceDao {
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance) {
		
		String sql = "INSERT INTO employeeHealthInsurance "
				+ "(empId, healthInsuranceSchemeName, coverageAmount) VALUES (?, ?,?)";
		getJdbcTemplate().update(sql,
				new Object[] { employeeHealthInsurance.getEmpId(), 
						employeeHealthInsurance.getHealthInsuranceSchemeName(), 
						employeeHealthInsurance.getCoverageAmount() });
	
	}

	@Override
	public void deleteEmployeeHealthInsuranceById(String empId) {
		
		String sql = "DELETE FROM employeeHealthInsurance WHERE empId = ?";
		getJdbcTemplate().update(sql, new Object[] { empId });
		
	}

}
