package com.resilience.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resilience.spring.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
