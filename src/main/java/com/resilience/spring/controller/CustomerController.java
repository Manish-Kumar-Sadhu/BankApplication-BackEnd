package com.resilience.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.resilience.spring.email.MessageController;

import com.resilience.spring.model.Customer;
import com.resilience.spring.repository.AccountRepository;
import com.resilience.spring.repository.CustomerRepository;
import com.resilience.spring.validator.CustomerValidator;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerRepository cr;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	private CustomerValidator rvalidator;
	
	
	@Autowired
	private CustomerRepository cRepo;
	
	//@Autowired(required=true)
	//private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@Autowired
	MessageController mc;
			


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
	
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer, Errors error)
	{

		//String encodedPassword = bCryptPasswordEncoder.encode(customer.getPassword());
		
		rvalidator.validate(customer, error);
		
		String myEmail = customer.getEmail();
		int count = cRepo.countUsersWithEmail(myEmail);	
		
		long myAadhar = customer.getAadhaar_card();
		int count1 = cRepo.countUsersWithAadhar(myAadhar);	
		
		String myPan = customer.getPan_card();
		int count2 = cRepo.countUsersWithPan(myPan);
		
		String mypassport = customer.getPan_card();
		int count3 = cRepo.countUsersWithpassport(mypassport);
		

		long mynumber = customer.getMobile_no();
		int count4 = cRepo.countUsersWithNumber(mynumber);
		
		if(count!=0) {

			System.out.println("Customer exists with this mailId");
			return ResponseEntity.ok("Customer exists with this mailId");
		}
		else if(count1!=0) {

			System.out.println("Customer with this Aadhaar_number already exists");
			return ResponseEntity.ok("Customer with this Aadhaar_number already exists");
		}
		else if(count2!=0) {

			System.out.println("Customer with this pan_number already exists");
			return ResponseEntity.ok("Customer with this pan_number already exists");
		}
		else if(count3!=0) {

			System.out.println("Customer with this passort_number already exists");
			return ResponseEntity.ok("Customer with this passort_number already exists");
		}
		else if(count4!=0) {

			System.out.println("Mobile number already exists");
			return ResponseEntity.ok("Mobile number already exists");
		}
		else if(error.hasErrors()) {
			
			System.out.println("invalid number");
			return ResponseEntity.ok("inavalid mobile number, Enter valid number....");
		}
		else if(cr.existsById(customer.getCustomer_id()))
		{
			return ResponseEntity.ok("Customer exists with id "+ customer.getCustomer_id());

		}
		else
        {
            cr.save(customer);
            return ResponseEntity.ok("Customer saved with id " + customer.getCustomer_id());
        }

	
	}

	@GetMapping(path = "/list/{page_no}/{size}", 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Customer>> getCustomerList(@PathVariable("page_no") int page_no, @PathVariable("size") int size) {
		//return ResponseEntity.ok(cr.findAll());
		Pageable firstPageWithTwoElements = PageRequest.of(page_no, size);
		return (ResponseEntity<Page<Customer>>) ResponseEntity.ok(cr.findAll(firstPageWithTwoElements));
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
		
		mc.sendMail(currentcustomer.get().getEmail(), "Welcome to Business Bank", 
				"You have successfully registered with the Business Bank. "
				+ "Your customer id is " + currentcustomer.get().getCustomer_id());

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

