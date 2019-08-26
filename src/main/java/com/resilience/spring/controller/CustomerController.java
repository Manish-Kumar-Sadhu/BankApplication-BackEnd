package com.resilience.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.resilience.spring.model.Customer;
import com.resilience.spring.repository.AccountRepository;
import com.resilience.spring.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerRepository cr;
	
	@Autowired
	AccountRepository accountRepository;
	

	
	@Autowired(required=true)
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@GetMapping(path="/find/{id}",
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
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
			produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer)
	{
		String encodedPassword = bCryptPasswordEncoder.encode(customer.getPassword());
		if(cr.existsById(customer.getCustomer_id()))
		{
			return ResponseEntity.ok("Customer exists with id "+ customer.getCustomer_id());
		}
		else
		{
			customer.setPassword(encodedPassword);
			cr.save(customer);
			return ResponseEntity.ok("Customer saved with id "+ customer.getCustomer_id());
		}
	}
	
	@GetMapping(path="/list",produces="application/json")
	public ResponseEntity<List<Customer>> getCustomerList(){
		return ResponseEntity.ok(cr.findAll());
	}
	
	@PutMapping(path="/update",
			produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer)
	{
//		Optional<Customer> currentcustomer=cr.findById(customer.getCustomer_id());
//		currentcustomer.get().setDistrict(customer.getDistrict());
//		currentcustomer.get().setEmail(customer.getEmail());
//		currentcustomer.get().setHouse_no(customer.getHouse_no());
//		currentcustomer.get().setPassword(customer.getPassword());
//		currentcustomer.get().setMobile_no(customer.getMobile_no());
//		currentcustomer.get().setState(customer.getState());
//		currentcustomer.get().setStreet(customer.getStreet());
		cr.save(customer);
		return ResponseEntity.ok("Customer updated with id: "+customer.getCustomer_id());
	}
	
	@DeleteMapping(path="/delete", 
			produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer)
	{
		if(cr.existsById(customer.getCustomer_id()))
		{
			Optional<Customer> currentcustomer=cr.findById(customer.getCustomer_id());
			currentcustomer.get().setCustomer_status((short) 0);
			return ResponseEntity.ok("Customer deleted with id "+ customer.getCustomer_id());
		}
		else
		{
			return ResponseEntity.ok("Customer does not exist with id "+ customer.getCustomer_id());
		}
	}
	
	@PutMapping(path="/activate/{id}",
			produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> activateCustomer(@PathVariable("id") int id)
	{
		Optional<Customer> currentcustomer=cr.findById(id);
		currentcustomer.get().setCustomer_status(1);
		return ResponseEntity.ok("Customer status activated");
	}
	
}
