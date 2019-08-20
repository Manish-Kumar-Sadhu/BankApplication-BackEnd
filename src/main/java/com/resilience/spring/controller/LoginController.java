package com.resilience.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resilience.spring.model.Customer;
import com.resilience.spring.model.Login;
import com.resilience.spring.repository.BankEmployeeRepository;
import com.resilience.spring.repository.CustomerRepository;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	CustomerRepository cr;
	
	@Autowired
	BankEmployeeRepository ber;
	
	@PostMapping(path="/login", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> login(@RequestBody Login log)
	{
		String check = log.getType();
		if (check == "customer")
		{
			Customer cust = cr.findByEmail();
			String mail=cust.getEmail();
			String pass=cust.getPassword();
			if (mail == log.getEmail() && pass ==log.getPassword())
			{
				return ResponseEntity.ok(cust);
			}
			else
			{
				return ResponseEntity.status(404).build();
			}
		}
		else
		{
			
		}
		return null;
	}
}
