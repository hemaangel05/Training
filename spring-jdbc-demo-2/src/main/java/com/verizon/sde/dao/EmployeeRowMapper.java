package com.verizon.sde.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.verizon.sde.model.Employee;

@Component
public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee e = new Employee();
		
		e.setEmpId(rs.getInt(1));
		e.setEmpName(rs.getString(2));
		e.setBasic(rs.getDouble(3));
		e.setHra(rs.getDouble(4));
		e.setDept(rs.getString(5));
		
		return e;
	}

}
