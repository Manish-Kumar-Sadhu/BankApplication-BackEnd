package com.resilience.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resilience.spring.model.Bank;
import com.resilience.spring.repository.BankRepository;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	BankRepository bankRepository;
	
	@GetMapping(path="/details" ,  produces="application/json")
	public ResponseEntity<List<Bank>> getBankDetails(){
		return ResponseEntity.ok(bankRepository.findAll());
	}
	
	
}
