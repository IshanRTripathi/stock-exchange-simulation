package com.mthree.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mthree.models.Employee;

@Component
public class MyDAO {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EmployeeRowMapper employeeRowMapper;
	
	public int registerCustomer() {
					
		return jdbcTemplate.update("INSERT into employee(name,email,salary) values(?,?,?)",new Object[] {"Mike","mike@gmail.com",1000});

		
	}
	
	
	public List<Employee> getAllEmployees() {
		
		
		return jdbcTemplate.query("SELECT * from employee",employeeRowMapper);

		
	}
	
	// Inner class
	
	  @Component
	  private class EmployeeRowMapper implements RowMapper<Employee>{
		
				@Override 
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee e = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
				return e;
	  }
			
		
		
	}

}
