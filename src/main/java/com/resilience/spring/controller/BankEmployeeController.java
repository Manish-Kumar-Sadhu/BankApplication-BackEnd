package com.resilience.spring.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.resilience.spring.model.BankEmployee;
import com.resilience.spring.repository.BankEmployeeRepository;

@RestController
@RequestMapping("/bankemployee")
public class BankEmployeeController {
	
	@Autowired
	BankEmployeeRepository br;
	
	@GetMapping(path="/find/{id}",
			produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity findBankEmployee(@PathVariable("id")int id)
	{
		Optional<BankEmployee> o =br.findById(id);
		if(o.isPresent())
		{
			return ResponseEntity.ok(o.get());
		}
		else
		{
			return ResponseEntity.status(404).build();
		}
	}
	
	@PostMapping(path="/save", 
			produces = {org.springframework.http.MediaType.TEXT_PLAIN_VALUE},
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveBankEmployee(@RequestBody BankEmployee bankemployee)
	{
		if(br.existsById(bankemployee.getEmployee_id()))
		{
			return ResponseEntity.ok("Employee exists with id "+ bankemployee.getEmployee_id());
		}
		else
		{
			br.save(bankemployee);
			return ResponseEntity.ok("Employee saved with id "+ bankemployee.getEmployee_id());
		}
	}

	@GetMapping(path="/list",produces="application/json")
	public ResponseEntity<List<BankEmployee>> getBankEmployeeList(){
		return ResponseEntity.ok(br.findAll());
	}
	
}
