package com.resilience.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resilience.spring.model.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {

}
