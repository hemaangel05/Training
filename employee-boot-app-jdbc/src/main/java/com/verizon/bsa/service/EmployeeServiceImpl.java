package com.verizon.bsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.bsa.dao.EmployeeDao;
import com.verizon.bsa.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao bookDao;

	@Override
	public Employee addBook(Employee book) {
		return bookDao.addBook(book);
	}

	@Override
	public Employee updateBook(Employee book) {
		return bookDao.updateBook(book);
	}

	@Override
	public Employee getBookById(int eid) {
		return bookDao.getBookById(eid);
	}

	@Override
	public boolean deleteBookById(int eid) {
		return bookDao.deleteBookById(eid);
	}

	@Override
	public List<Employee> getAllBooks() {
		return bookDao.getAllBooks();
	}

}
