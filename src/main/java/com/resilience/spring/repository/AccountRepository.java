package com.resilience.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.resilience.spring.model.Account;
import com.resilience.spring.model.Customer;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	@Query("select * from Account a where a.customer_id = :id")
	public List<Account> findAccountsByCustomerId(@Param("id") int id);
	
}
