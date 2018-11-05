package com.verizon.sde.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.sde.dao.EmployeeDAO;
import com.verizon.sde.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO empDAO;

	@Override
	public void addEmployee(Employee emp) {
		empDAO.addEmployee(emp);
		
	}

	@Override
	public void removeEmployee(int empId) {
		empDAO.removeEmployee(empId);
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		empDAO.updateEmployee(emp);
		
	}

	@Override
	public Employee getEmployee(int empId) {
		
		return empDAO.getEmployee(empId);
	}

	@Override
	public List<Employee> getEmployees() {
		
		return empDAO.getEmployees();
	}

	@Override
	public boolean exists(int empId) {
		return empDAO.getEmployee(empId)!=null;
	}

}
