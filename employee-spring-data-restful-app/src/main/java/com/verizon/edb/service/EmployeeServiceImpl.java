package com.verizon.edb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.edb.model.Employee;
import com.verizon.edb.dao.EmployeeRepository;
import com.verizon.edb.model.Department;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public Employee getEmployeeById(long empId) {
		Employee emp = null;
		
		
		
		Optional<Employee> optEmp = empRepo.findById(empId);
		if(optEmp.isPresent()) {
			emp = optEmp.get();
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee emp) {
		
		return empRepo.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public boolean deleteEmployee(long empId) {
		boolean isDeleted = false;
		if(empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public boolean existsByEmpName(String name) {
		
		return empRepo.existsByEmpName(name);
	}

	@Override
	public Employee findByEmpName(String name) {
		
		return empRepo.findByEmpName(name);
	}

	@Override
	public List<Employee> findAllByDepartment(String department) {
		
		return empRepo.findAllByDepartment(department);
	}

	

}
