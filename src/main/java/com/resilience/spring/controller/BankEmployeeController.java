package com.resilience.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resilience.spring.model.BankEmployee;
import com.resilience.spring.model.Customer;
import com.resilience.spring.repository.BankEmployeeRepository;

@RestController
@RequestMapping("/bankEmployee")
public class BankEmployeeController {

	@Autowired
	BankEmployeeRepository bankEmployeeRepository;

	@GetMapping(path = "/list", produces = "application/json")
	public ResponseEntity<List<BankEmployee>> getEmpList() {
		return ResponseEntity.ok(bankEmployeeRepository.findAll());
	}

	@PostMapping(path = "/save", 
			produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE, 
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveEmployee(@RequestBody BankEmployee bankEmployee) {
		boolean empExists = bankEmployeeRepository.findByEmail(bankEmployee.getEmail()) != null ? true : false;
		if (!empExists) {
			bankEmployeeRepository.save(bankEmployee);
			return ResponseEntity.ok("Employee saved with mail id " + bankEmployee.getEmail() + " and emp id is :"
					+ bankEmployee.getEmployee_id());
			
		} else {
			return ResponseEntity.ok("Employee exists with mail " + bankEmployee.getEmail());
		}
	}

	@PutMapping(path = "/update", 
			produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE, 
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<BankEmployee>> updateBankEmployee(@RequestBody BankEmployee bankEmployee) {
		Optional<BankEmployee> currentEmployee = bankEmployeeRepository.findById(bankEmployee.getEmployee_id());
		currentEmployee.get().setDistrict(bankEmployee.getDistrict());
		currentEmployee.get().setEmail(bankEmployee.getEmail());
		currentEmployee.get().setHouse_no(bankEmployee.getHouse_no());
		currentEmployee.get().setPassword(bankEmployee.getPassword());
		currentEmployee.get().setMobile_no(bankEmployee.getMobile_no());
		currentEmployee.get().setState(bankEmployee.getState());
		currentEmployee.get().setStreet(bankEmployee.getStreet());

		return ResponseEntity.ok(currentEmployee);
	}

}
