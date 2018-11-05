package com.verizon.bsa.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.verizon.bsa.model.Employee;

@Repository
public class EmployeeDAOJdbcTemplateImpl implements EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;

	@Override
	public Employee addBook(Employee book) {
		int count = jdbcTemplate.update(IQueryMapper.INS_BOOK_QRY,
				book.getEid(),
				book.getName(),
				book.getBasic(),
				book.getHra(),
				book.getDept()
				);
		
		if(count<1) {
			book = null;
		}
		
		
		return book;
	}
	
	@Autowired
	public EmployeeDAOJdbcTemplateImpl(DataSource dataSource) {
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Employee updateBook(Employee book) {
		int count = jdbcTemplate.update(IQueryMapper.UPDATE_BOOK_QRY,
				
				book.getName(),
				book.getBasic(),
				book.getHra(),
				book.getDept(),
				book.getEid()
				);
		
		if(count<1) {
			book=null;
		}
		return book;
	}

	@Override
	public Employee getBookById(int eid) {
		List<Employee> books = jdbcTemplate.query(
				IQueryMapper.GET_BOOK_QRY,
				new Object[] {eid},
				new EmployeeRowMapper());
		
		Employee book=null;
		if(books!=null && books.size()==1) {
			book = books.get(0);
		}
		return book;
	}

	@Override
	public boolean deleteBookById(int eid) {
		boolean isDeleted = false;
		
		int count = jdbcTemplate.update(
				IQueryMapper.DEL_BOOK_QRY,eid);
		
		if(count>=1) {
			isDeleted = true;
		}
				
		return isDeleted;
	}

	@Override
	public List<Employee> getAllBooks() {
		List<Employee> books = jdbcTemplate.query(
				IQueryMapper.GET_ALL_BOOK_QRY,
				new EmployeeRowMapper());
		return books;
	}

}
