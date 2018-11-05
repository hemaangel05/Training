package com.verizon.sde.service;

import java.util.List;

import com.verizon.sde.model.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee emp);
	public void removeEmployee(int empId);
	public void updateEmployee(Employee emp);
	public Employee getEmployee(int empId);
	public List<Employee> getEmployees();
	public boolean exists(int empId);

}
