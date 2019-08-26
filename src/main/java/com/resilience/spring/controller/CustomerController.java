package com.resilience.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//MessageController mc = new MessageController();
			
	

//	@Autowired
//	AccountRepository accountRepository;

	@GetMapping(path = "/find/{id}", 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> findCustomerById(@PathVariable("id") int id) {
		Optional<Customer> o = cr.findCustomer(id);
		if (o.isPresent()) {
			return ResponseEntity.ok(o.get());
		} else {
			return ResponseEntity.status(404).build();
		}
	}

	
	@PostMapping(path="/save", 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer)
	{
//		if(cr.existsById(customer.getCustomer_id()))
//		{
//			return ResponseEntity.ok("Customer exists with id "+ customer.getCustomer_id());
//		}
		if(cr.findByEmail(customer.getEmail())!=null) {
			return ResponseEntity.ok("Customer exists with email id "+ customer.getEmail());
		}
		else
		{
			cr.save(customer);
//			mc.sendMail("businessbankofindia@gmail.com", "Welcome to Business Bank", 
//					"You have successfully registered with the Business Bank. Your customer id is " + customer.getCustomer_id());
			return ResponseEntity.ok("Customer saved with id " + customer.getCustomer_id());
		}
	}

	@GetMapping(path = "/list", 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getCustomerList() {
		return ResponseEntity.ok(cr.findAll());
	}

	@PutMapping(path = "/update", 
			produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE, 
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
		Optional<Customer> currentcustomer=cr.findById(customer.getCustomer_id());
		currentcustomer.get().setDistrict(customer.getDistrict());
		currentcustomer.get().setEmail(customer.getEmail());
		currentcustomer.get().setHouse_no(customer.getHouse_no());
		//currentcustomer.get().setPassword(customer.getPassword());
		currentcustomer.get().setMobile_no(customer.getMobile_no());
		currentcustomer.get().setState(customer.getState());
		currentcustomer.get().setStreet(customer.getStreet());
		cr.save(customer);
		return ResponseEntity.ok("Customer updated with id: " + customer.getCustomer_id());
	}

	@DeleteMapping(path = "/delete/{id}", 
			produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE, 
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id) {
		
		if(cr.existsById(id))
		{
			Optional<Customer> currentcustomer = cr.findById(id);
			currentcustomer.get().setCustomer_status(0);
			return ResponseEntity.ok("Customer deleted with id " + id);
		} 
		else 
		{
			return ResponseEntity.ok("Customer does not exist with id " + id);
		}
	}



	@PutMapping(path = "/activate/{id}", 
			produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> activateCustomer(@PathVariable("id") int id) {
		if(cr.existsById(id))
		{
		Optional<Customer> currentcustomer = cr.findById(id);
		currentcustomer.get().setCustomer_status(1);
		cr.save(currentcustomer.get());
		
//		mc.sendMail("prakharkhandelwal11@gmail.com", "Welcome to Business Bank", 
//				"You have successfully registered with the Business Bank. Your customer id is " + currentcustomer.get().getCustomer_id());

		return ResponseEntity.ok("Customer status activated");
		}
		else
		{
			return ResponseEntity.ok("Customer does not exist with id " + id);
		}
	}
	

	@GetMapping(path = "/inactivecustomerlist", 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getInactiveCustomerList() {
		return ResponseEntity.ok(cr.findInactiveCustomers());
	}

}

