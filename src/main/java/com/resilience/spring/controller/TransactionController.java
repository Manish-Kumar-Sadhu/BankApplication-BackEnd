package com.resilience.spring.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resilience.spring.model.Account;
import com.resilience.spring.model.Customer;
import com.resilience.spring.model.Transaction;
import com.resilience.spring.model.TransactionType;
import com.resilience.spring.repository.AccountRepository;
import com.resilience.spring.repository.CustomerRepository;
import com.resilience.spring.repository.TransactionRepository;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionRepository tr;
	
	@Autowired
	CustomerRepository cr;
	
	@Autowired
	AccountRepository ar;
	
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
	
	@PostMapping(path="/new/{id}",
			produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> newTransaction(@RequestBody Transaction transaction,@PathVariable("id")int customer_id)
	{
		int fromAccount = transaction.getFrom_acccount_number();
		int toAccount = transaction.getTo_accounnt_number();
		int amount = transaction.getAmount();
		
		Optional<Account> from_account = ar.findById(fromAccount);
		Optional<Account> to_account = ar.findById(toAccount);
		
		if(from_account.get().getBalance() >= amount)
		{
			from_account.get().setBalance(from_account.get().getBalance()-amount);
			to_account.get().setBalance(to_account.get().getBalance()+amount);
			
			Optional<Customer> currentCustomer=cr.findById(customer_id);
			transaction.setCustomer(currentCustomer.get());
			tr.save(transaction);
			
			return ResponseEntity.ok("Transaction successfully completed");
		}
		else
		{
			return ResponseEntity.ok("Insufficient Balance");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(path="/{customer_id}",
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<Transaction>> getTransactionsOfCustomer(@PathVariable("customer_id") int customer_id)
	{
		//cr.findById(customer_id).get().getTransactions();
		return (ResponseEntity<Set<Transaction>>) cr.findById(customer_id).get().getTransactions();
	}
}
