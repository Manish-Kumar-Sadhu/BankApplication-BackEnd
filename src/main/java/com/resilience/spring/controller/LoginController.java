package com.resilience.spring.controller;

import java.util.Optional;

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
	
	
	//, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.TEXT_PLAIN_VALUE)
	@PostMapping(path="/login", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity login(@RequestBody Login log)
	{
		String check = log.getType();
		if (check.equals("customer"))
		{
			Customer cust = cr.findByEmail(log.getEmail());
			String mail=cust.getEmail();
			String pass=cust.getPassword();
			
			if (mail.equals(log.getEmail())&& pass.equals(log.getPassword()))
			{
				return ResponseEntity.ok(cust);
			}
			else
			{
				return ResponseEntity.status(404).build();
			}
		}
		return null;
	}
}
