package com.resilience.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resilience.spring.email.AccountActivationEmail;
import com.resilience.spring.email.AccountActivationEmailController;
import com.resilience.spring.email.AccountRegistrationEmail;
import com.resilience.spring.email.AccountRegistrationEmailController;
import com.resilience.spring.email.CustomerActivationEmail;
import com.resilience.spring.model.Account;
import com.resilience.spring.model.AccountType;
import com.resilience.spring.model.Customer;
import com.resilience.spring.repository.AccountRepository;
import com.resilience.spring.repository.AccountTypeRepository;
import com.resilience.spring.repository.CustomerRepository;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountRepository ar;

	@Autowired
	CustomerRepository cr;

	@Autowired
	AccountTypeRepository atr;

	@Autowired
	AccountRegistrationEmailController arec;
	
	@Autowired
	AccountActivationEmailController aaec;

	@GetMapping(path = "/find/{no}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> findAccount(@PathVariable("no") int no) {
		Optional<Account> o = ar.findByAccountId(no);

		if (o.isPresent()) {
			return ResponseEntity.ok(o.get());
		} else {
			return ResponseEntity.status(404).build();
		}
	}

	@GetMapping(path = "/list", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getAllAccounts() {
		return ResponseEntity.ok(ar.findAll());
	}

	// returns inactive accounts also
	@GetMapping(path = "/list/{customer_id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
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

	// to be reviewed
	// whether account body is required or not, probably yes
	@PostMapping(path = "/save/{customer_id}/{type_id}", produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveAccount(@RequestBody Account account,
			@PathVariable("customer_id") int customer_id, @PathVariable("type_id") int type_id)
			throws MessagingException {
		if (ar.existsById(account.getAccount_no())) {
			return ResponseEntity.ok("Account exists with no. " + account.getAccount_no());
		} else {
			Optional<Customer> currentCustomer = cr.findById(customer_id);
			Optional<AccountType> currentAccountType = atr.findById(type_id);
			account.setCustomer(currentCustomer.get());
			account.setAccountType(currentAccountType.get());
			ar.save(account);
			AccountRegistrationEmail.to = account.getCustomer().getEmail();
			AccountRegistrationEmail.subject = "Iron Bank Of Braavos | Account Request | ANo: "
					+ account.getAccount_no();
			arec.sendMail();
			return ResponseEntity.ok("Account saved with no. " + account.getAccount_no());
		}
	}

	// can update inactive accounts
	@PutMapping(path = "/update", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateAccount(@RequestBody Account account) {
		Optional<Account> currentaccount = ar.findById(account.getAccount_no());
		currentaccount.get().setAccount_status(account.getAccount_status());
		currentaccount.get().setAccountType(account.getAccount_type_id());
		currentaccount.get().setBalance(account.getBalance());

		ar.save(account);
		return ResponseEntity.ok("Account updated successfully.");
	}

	// no action on deactivated account, like a message
	@DeleteMapping(path = "/delete", produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
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
	public ResponseEntity<String> activateAccount(@PathVariable("id") int id) throws MessagingException {
		if (ar.existsById(id)) {
			Optional<Account> currentaccount = ar.findById(id);
			currentaccount.get().setAccount_status(1);
			ar.save(currentaccount.get());
			AccountActivationEmail.to = currentaccount.get().getCustomer().getEmail();
			AccountActivationEmail.subject = "Iron Bank Of Braavos | Account Activated | ANo: "
					+ currentaccount.get().getAccount_no();
			aaec.sendMail();
			return ResponseEntity.ok("Account status activated");
		} else {
			return ResponseEntity.ok("Account does not exist with no. " + id);
		}
	}

	@GetMapping(path = "/inactiveaccountlist", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getInactiveAccountList() {
		return ResponseEntity.ok(ar.findInactiveAccounts());
	}

	@GetMapping(path = "/activeaccountlist", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getActiveAccountList() {
		return ResponseEntity.ok(ar.findActiveAccounts());
	}
}
