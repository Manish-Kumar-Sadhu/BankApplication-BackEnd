package com.resilience.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resilience.spring.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {

}
