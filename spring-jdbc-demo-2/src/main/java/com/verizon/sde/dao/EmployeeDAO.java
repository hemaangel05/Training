package com.verizon.sde.dao;

import java.util.List;

import com.verizon.sde.model.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(Employee emp);
	public void removeEmployee(int empId);
	public void updateEmployee(Employee emp);
	public Employee getEmployee(int empId);
	public List<Employee> getEmployees();

}
