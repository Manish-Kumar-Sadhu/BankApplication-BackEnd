package com.resilience.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resilience.spring.model.TransactionType;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {

}
