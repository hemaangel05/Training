package com.verizon.sde.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.verizon.sde.model.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private NamedParameterJdbcTemplate jtmp;
	
	@Autowired
	private EmployeeRowMapper rowMapper;
	
	
	
	public EmployeeDAOImpl(DataSource ds) {
		
		this.jtmp = new NamedParameterJdbcTemplate(ds);
		//super();
	}

	@Override
	public void addEmployee(Employee emp) {
		jtmp.update(IQueryMapper.INS_ITEM_QRY,
				new BeanPropertySqlParameterSource(emp)
				);
		
	}

	@Override
	public void removeEmployee(int empId) {
		jtmp.update(IQueryMapper.DEL_ITEM_QRY,
				Collections.singletonMap("empId",empId));
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		jtmp.update(IQueryMapper.UPD_ITEM_QRY,
				new BeanPropertySqlParameterSource(emp)
				);
		
	}

	@Override
	public Employee getEmployee(int empId) {
		List<Employee> items = jtmp.query(IQueryMapper.GET_ITEM_QRY,
				Collections.singletonMap("empId", empId),
				rowMapper);
		
		return items!=null && items.size()>0?items.get(0):null;
	}

	@Override
	public List<Employee> getEmployees() {
		return jtmp.query(IQueryMapper.GET_ALL_ITEMS_QRY, 
				rowMapper);
	}

}
