package com.verizon.bsa.service;

import java.util.List;

import com.verizon.bsa.model.Employee;

public interface EmployeeService {
	Employee addBook(Employee emp);
	Employee updateBook(Employee emp);
	Employee getBookById(int eid);
	boolean deleteBookById(int eid);
	List<Employee> getAllBooks();
}
