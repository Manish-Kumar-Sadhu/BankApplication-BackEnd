package com.resilience.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resilience.spring.model.Transaction;
import com.resilience.spring.repository.TransactionRepository;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionRepository tr;
	
	@GetMapping(path="/find/{id}",
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findTransaction(@PathVariable("id")int id)
	{
		Optional<Transaction> o =tr.findById(id);
		if(o.isPresent())
		{
			return ResponseEntity.ok(o.get());
		}
		else
		{
			return ResponseEntity.status(404).build();
		}
	}
	
	@GetMapping(path = "/list") 
	public ResponseEntity<List<Transaction>> getAllTransactions(){
		return ResponseEntity.ok(tr.findAll());
	}
	
	@PutMapping(path="/new",
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Transaction>> newTransaction(@RequestBody Transaction transaction)
	{
		transaction.getTransaction_type();
		return null;
	}
}
