package com.verizon.bsa.dao;

import java.util.List;

import com.verizon.bsa.model.Employee;

public interface EmployeeDao {

	Employee addBook(Employee book);
	Employee updateBook(Employee book);
	Employee getBookById(int eid);
	boolean deleteBookById(int eid);
	List<Employee> getAllBooks();
	
}
