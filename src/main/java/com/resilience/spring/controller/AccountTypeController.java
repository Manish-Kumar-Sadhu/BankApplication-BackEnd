package com.resilience.spring.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.resilience.spring.model.AccountType;
import com.resilience.spring.repository.AccountTypeRepository;

@RestController
@RequestMapping("/accounttype")
public class AccountTypeController {
	
	@Autowired
	AccountTypeRepository ar;

	@GetMapping(path="/find/{id}",
			produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity findAccountType(@PathVariable("id")int id)
	{
		Optional<AccountType> o =ar.findById(id);
		if(o.isPresent())
		{
			return ResponseEntity.ok(o.get());
		}
		else
		{
			return ResponseEntity.status(404).build();
		}
	}
	
//	@PostMapping(path="/save", 
//			produces = {org.springframework.http.MediaType.TEXT_PLAIN_VALUE},
//			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> saveAccountType(@RequestBody AccountType accountType)
//	{
//		if(ar.existsById(accountType.getAccount_type_id()))
//		{
//			return ResponseEntity.ok("Customer exists with id "+ accountType.getAccount_type_id());
//		}
//		else
//		{
//			ar.save(accountType);
//			return ResponseEntity.ok("Customer saved with id "+ accountType.getAccount_type_id());
//		}
//	}
	
	@GetMapping(path="/list",produces="application/json")
	public ResponseEntity<List<AccountType>> getAccountTypeList(){
		return ResponseEntity.ok(ar.findAll());
	}
}
