package com.verizon.sde.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.sde.model.Employee;
import com.verizon.sde.service.EmployeeService;

@RestController
@RequestMapping("/emps")
public class EmployeeAPI {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getALlEmployees() {
		ResponseEntity<List<Employee>> resp = null;
		List<Employee> items = service.getEmployees();
		if (items != null && items.size() > 0)
			resp = new ResponseEntity<List<Employee>>(items, HttpStatus.OK);
		else
			resp = new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		return resp;
	}
	
	@GetMapping("/{empid}")
	public ResponseEntity<Employee> getItem(@PathVariable("empid") int empid) {
		ResponseEntity<Employee> resp = null;
		Employee item = service.getEmployee(empid);
		if (item != null)
			resp = new ResponseEntity<Employee>(item, HttpStatus.OK);
		else
			resp = new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee item) {
		ResponseEntity<Employee> resp = null;
		if (item != null && !service.exists(item.getEmpId())) {
			service.addEmployee(item);
			resp = new ResponseEntity<Employee>(item, HttpStatus.OK);
		} else
			resp = new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		return resp;
	}

	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee item) {
		ResponseEntity<Employee> resp = null;
		if (item != null && service.exists(item.getEmpId())) {
			service.updateEmployee(item);
			resp = new ResponseEntity<Employee>(item, HttpStatus.OK);
		} else
			resp = new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		return resp;
	}

	@DeleteMapping("/{empid}")
	public ResponseEntity<Void> delItem(@PathVariable("empid") int empid) {
		ResponseEntity<Void> resp = null;
		if (service.exists(empid)) {
			service.removeEmployee(empid);
			resp = new ResponseEntity<>(HttpStatus.OK);
		} else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}


}
