package com.resilience.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resilience.spring.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
