//package com.resilience.spring.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.resilience.spring.model.Transaction;
//import com.resilience.spring.repository.TransactionRepository;
//
//@RestController
//@RequestMapping("/flaggedtransactions")
//public class FlaggedTransactionController {
//	
//	@Autowired
//	TransactionRepository tr;
//	
//	@GetMapping(path = "/list", 
//			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Transaction>> getAllFlaggedTransactions() {
//		return ResponseEntity.ok(tr.findAllFlagged());
//	}
//
//}
