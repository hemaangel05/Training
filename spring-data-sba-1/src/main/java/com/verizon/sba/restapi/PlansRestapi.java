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


import com.verizon.sba.model.Plans;
import com.verizon.sba.service.PlansService;

@CrossOrigin
@RestController
@RequestMapping("/plans")
public class PlansRestapi {
	
	@Autowired
	private PlansService service;
	
	@GetMapping	
	public ResponseEntity<List<Plans>> getAllPlans(){ 
		return new ResponseEntity<>(
				service.getAllPlans(),HttpStatus.OK) ; 
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Plans> getPlanById(@PathVariable("id") long orderId) {
		ResponseEntity<Plans> resp;
		Plans c = service.getPlanById(orderId);
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(c, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{field}/{srhValue}")
	public ResponseEntity<List<Plans>> getAllContacts(@PathVariable("field") String fieldBy,
			@PathVariable("srhValue") int searchValue) {

		List<Plans> results = null;

		switch (fieldBy) {
		case "speed":
			results = service.findAllBySpeed(searchValue);
			break;
		case "max_usage":
			results = service.findAllByMaxUsage(searchValue);
			break;
		case "price":
			results = service.findAllByPrice(searchValue);
			break;
		}

		ResponseEntity<List<Plans>> resp;

		if (results == null)
			resp = new ResponseEntity<List<Plans>>(HttpStatus.BAD_REQUEST);
		else
			resp = new ResponseEntity<List<Plans>>(results,HttpStatus.OK);

		return resp;

	}
	
	@PostMapping
	public ResponseEntity<Plans> addPlan(@RequestBody Plans con) {
		ResponseEntity<Plans> resp = null;

		
		if (resp == null) {
			Plans c = service.addPlan(con);
			if (c == null)
				resp = new ResponseEntity<Plans>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Plans>(c, HttpStatus.OK);
		}

		return resp;
	}
	
	@PutMapping
	public ResponseEntity<Plans> updatePlan(@RequestBody Plans con) {
		ResponseEntity<Plans> resp = null;
		Plans c = service.getPlanById(con.getpTitle());

		
		if (resp == null) {
			c = service.updatePlan(con);
			if (c == null)
				resp = new ResponseEntity<Plans>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Plans>(c, HttpStatus.OK);
		}

		return resp;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable("id") long contactId) {
		ResponseEntity<Void> resp = null;

		if (service.deletePlan(contactId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}

}
