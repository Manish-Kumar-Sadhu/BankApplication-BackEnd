package com.resilience.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resilience.spring.model.AccountType;
import com.resilience.spring.repository.AccountTypeRepository;

@RestController
@RequestMapping("/accounttype")
public class AccountTypeController {

	@Autowired
	AccountTypeRepository atr;
	
	@GetMapping(path="/list" ,
			produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountType>> getAccountTypes(){
		return ResponseEntity.ok(atr.findAll());
	}
	
	@GetMapping(path="/find/{id}",
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findAccountType(@PathVariable("id")int id)
	{
		Optional<AccountType> o =atr.findById(id);
		if(o.isPresent())
		{
			return ResponseEntity.ok(o.get());
		}
		else
		{
			return ResponseEntity.status(404).build();
		}
	}
	
}
