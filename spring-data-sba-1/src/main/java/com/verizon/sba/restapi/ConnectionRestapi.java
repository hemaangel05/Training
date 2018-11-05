package com.verizon.sba.restapi;

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

import com.verizon.sba.model.Connection;
import com.verizon.sba.service.ConnectionService;

@CrossOrigin
@RestController
@RequestMapping("/connections")
public class ConnectionRestapi {
	
	@Autowired
	private ConnectionService service;
	
	@GetMapping	
	public ResponseEntity<List<Connection>> getAllOrders(){ 
		return new ResponseEntity<>(
				service.getAllOrders(),HttpStatus.OK) ; 
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Connection> getOrderById(@PathVariable("id") long orderId) {
		ResponseEntity<Connection> resp;
		Connection c = service.getOrderById(orderId);
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(c, HttpStatus.OK);
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<Connection> addOrder(@RequestBody Connection con) {
		ResponseEntity<Connection> resp = null;

		
		if (resp == null) {
			Connection c = service.addOrder(con);
			if (c == null)
				resp = new ResponseEntity<Connection>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Connection>(c, HttpStatus.OK);
		}

		return resp;
	}
	
	@PutMapping
	public ResponseEntity<Connection> updateOrder(@RequestBody Connection con) {
		ResponseEntity<Connection> resp = null;
		Connection c = service.getOrderById(con.getOrderid());

		
		if (resp == null) {
			c = service.updateOrder(con);
			if (c == null)
				resp = new ResponseEntity<Connection>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Connection>(c, HttpStatus.OK);
		}

		return resp;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable("id") long contactId) {
		ResponseEntity<Void> resp = null;

		if (service.deleteOrder(contactId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}

}
