package com.verizon.edb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verizon.edb.model.Department;
import com.verizon.edb.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	boolean existsByEmpName(String name);
	Employee findByEmpName(String name);
	
	List<Employee> findAllByDepartment(String department);
}
