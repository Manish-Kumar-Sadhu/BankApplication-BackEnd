package com.resilience.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resilience.spring.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

//	@Query("select a from Account a where a.customer_id = :id")
//	public List<Account> findAccountsByCustomerId(@Param("id") int id);
	
}
