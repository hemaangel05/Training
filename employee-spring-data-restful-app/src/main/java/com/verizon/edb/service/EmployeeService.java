package com.verizon.edb.service;

import java.util.List;


import com.verizon.edb.model.Employee;

public interface EmployeeService {
	
	Employee getEmployeeById(long empId);
	List<Employee> getAllEmployees();
	Employee addEmployee(Employee emp);
	Employee updateEmployee(Employee emp);
	boolean deleteEmployee(long empId);
	
	boolean existsByEmpName(String name);
	Employee findByEmpName(String name);
	List<Employee> findAllByDepartment(String department);
	

}
