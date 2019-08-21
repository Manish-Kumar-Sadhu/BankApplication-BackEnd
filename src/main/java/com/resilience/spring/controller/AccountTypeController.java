package com.resilience.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.resilience.spring.model.AccountType;
import com.resilience.spring.repository.AccountTypeRepository;

@RestController
@RequestMapping("/accountType")
public class AccountTypeController {

	@Autowired
	AccountTypeRepository accountTypeRepo;
	
	@GetMapping(path="/list" ,produces="application/json")
	public ResponseEntity<List<AccountType>> getAccountTypes(){
		return ResponseEntity.ok(accountTypeRepo.findAll());
	}
	
}
