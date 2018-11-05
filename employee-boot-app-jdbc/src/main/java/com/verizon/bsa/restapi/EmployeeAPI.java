package com.verizon.bsa.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.bsa.model.Employee;
import com.verizon.bsa.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class EmployeeAPI {
	@Autowired
	private EmployeeService empService;

	@GetMapping
	public ResponseEntity<List<Employee>> listBooksAction() {
		return new ResponseEntity<List<Employee>>(empService.getAllBooks(), HttpStatus.OK);
	}

	@GetMapping("/{eid}")
	public ResponseEntity<Employee> getBookAction(@PathVariable("eid") int eid) {
		ResponseEntity<Employee> resp = null;
		Employee b = empService.getBookById(eid);
		if (b == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(b, HttpStatus.OK);
		return resp;
	}

	@DeleteMapping("/{eid}")
	public ResponseEntity<Void> deleteBookAction(@PathVariable("eid") int eid) {
		ResponseEntity<Void> resp = null;

		boolean isDeleted = empService.deleteBookById(eid);

		if (!isDeleted)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(HttpStatus.OK);
		return resp;
	}

	@PostMapping
	public ResponseEntity<Employee> addBookAction(@RequestBody Employee employee) {
		ResponseEntity<Employee> resp = null;
		employee = empService.addBook(employee);

		if (employee != null)
			resp = new ResponseEntity<>(employee, HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		return resp;
	}

	@PutMapping
	public ResponseEntity<Employee> updateBookAction(@RequestBody Employee employee) {
		ResponseEntity<Employee> resp = null;

		if (empService.getBookById(employee.getEid()) == null) {
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			employee = empService.updateBook(employee);

			if (employee != null)
				resp = new ResponseEntity<>(employee, HttpStatus.OK);
			else
				resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
}
