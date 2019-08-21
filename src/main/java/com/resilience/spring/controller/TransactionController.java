package com.resilience.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resilience.spring.model.Transaction;
import com.resilience.spring.repository.TransactionRepository;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	TransactionRepository transactionRepository;
	
	@GetMapping(path = "/list") 
	public ResponseEntity<List<Transaction>> getAllTransactions(){
		return ResponseEntity.ok(transactionRepository.findAll());
	}
	
	
}
