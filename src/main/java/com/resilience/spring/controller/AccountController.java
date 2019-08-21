package com.resilience.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resilience.spring.model.Account;
import com.resilience.spring.repository.AccountRepository;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	
	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping(path = "/list" , produces="application/json")
	public ResponseEntity<List<Account>> getAllAccounts(){
		return ResponseEntity.ok(accountRepository.findAll());
	}
}
