package com.resilience.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resilience.spring.model.Customer;
import com.resilience.spring.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerRepository cr;
	
	@GetMapping(path="/find/{id}",
			produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity findCustomer(@PathVariable("id")int id)
	{
		Optional<Customer> o =cr.findById(id);
		if(o.isPresent())
		{
			return ResponseEntity.ok(o.get());
		}
		else
		{
			return ResponseEntity.status(404).build();
		}
	}
	
	@PostMapping(path="/save", 
			produces = {org.springframework.http.MediaType.TEXT_PLAIN_VALUE},
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveEmp(@RequestBody Customer customer)
	{
		if(cr.existsById(customer.getCustomer_id()))
		{
			return ResponseEntity.ok("Customer exists with id "+ customer.getCustomer_id());
		}
		else
		{
			cr.save(customer);
			return ResponseEntity.ok("Customer saved with id "+ customer.getCustomer_id());
		}
	}
	
	@GetMapping(path="/list",produces="application/json")
	public ResponseEntity<List<Customer>> getCustomerList(){
		return ResponseEntity.ok(cr.findAll());
	}
}
