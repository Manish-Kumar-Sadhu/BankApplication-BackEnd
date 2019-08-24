package com.resilience.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.resilience.spring.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

//	@Query("select a from Account a where a.customer_id = :id")
//	public List<Account> findAccountsByCustomerId(@Param("id") int id);
//	
	@Query("select a from Account a  join a.customer c where c.customer_id= :id ")
	public List<Account> findAccountsByCustomerId(@Param("id") int id);
	
	@Query("select a from Account a where a.account_status = 0")
	public List<Account> findInactiveAccounts();
	
	@Query("select a from Account a where a.account_no = :no and a.account_status = 1")
	public Optional<Account> findById(int no);
	
	@Query("select a from Account a where a.account_status = 1")
	public List<Account> findAll();
}

