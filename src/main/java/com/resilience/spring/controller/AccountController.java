package com.resilience.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resilience.spring.model.Account;
import com.resilience.spring.model.Customer;
import com.resilience.spring.repository.AccountRepository;
import com.resilience.spring.repository.CustomerRepository;

@RestController
@RequestMapping("/account")
public class AccountController {

	
	@Autowired
	AccountRepository ar;

	@Autowired
	CustomerRepository cr;

	@GetMapping(path = "/find/{no}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> findAccount(@PathVariable("no") int no) {
		Optional<Account> o = ar.findById(no);

		if (o.isPresent()) {
			return ResponseEntity.ok(o.get());
		} else {
			return ResponseEntity.status(404).build();
		}
	}

	@GetMapping(path = "/list", 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getAllAccounts() {
		return ResponseEntity.ok(ar.findAll());
	}

	@GetMapping(path = "/list/{customer_id}", 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getAccountsOfCustomer(@PathVariable("customer_id") int customer_id) {

		if (cr.findById(customer_id) != null) {

			if (ar.findAccountsByCustomerId(customer_id) != null) {
				return ResponseEntity.ok(ar.findAccountsByCustomerId(customer_id));
			} else {
				return ResponseEntity.ok("No accounts found");
			}

		} else {
			return ResponseEntity.ok("Unauthorisd user");
		}
	}

	@PostMapping(path = "/save/{id}", 
			produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE, 
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveAccount(@RequestBody Account account, @PathVariable("id") int customer_id) {
		if (ar.existsById(account.getAccount_no())) {
			return ResponseEntity.ok("Account exists with no. " + account.getAccount_no());
		} else {
			Optional<Customer> currentCustomer = cr.findById(customer_id);
			account.setCustomer(currentCustomer.get());
			ar.save(account);
			return ResponseEntity.ok("Account saved with no. " + account.getAccount_no());
		}
	}

	@PutMapping(path = "/update", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateAccount(@RequestBody Account account) {
//		Optional<Account> currentaccount = ar.findById(account.getAccount_no());
//		currentaccount.get().setAccount_status(account.getAccount_status());
//		currentaccount.get().setAccountType(account.getAccountType());
//		currentaccount.get().setBalance(account.getBalance());

		ar.save(account);
		return ResponseEntity.ok("Account updated successfully.");
	}

	@DeleteMapping(path = "/delete", 
			produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE, 
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteAccount(@RequestBody Account account) {
		if (ar.existsById(account.getAccount_no())) {
			Optional<Account> currentaccount = ar.findById(account.getAccount_no());
			currentaccount.get().setAccount_status(0);
			return ResponseEntity.ok("Account deleted with no. " + account.getAccount_no());
		} else {
			return ResponseEntity.ok("Account does not exist with no. " + account.getAccount_no());
		}
	}

	@PutMapping(path = "/activate/{id}", produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> activateAccount(@PathVariable("id") int id) {
		Optional<Account> currentaccount = ar.findById(id);
		currentaccount.get().setAccount_status(1);
		return ResponseEntity.ok("Account status activated");
	}
	
	@GetMapping(path = "/inactiveaccountlist", 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getInactiveAccountList() {
		return ResponseEntity.ok(ar.findInactiveAccounts());
	}
}
