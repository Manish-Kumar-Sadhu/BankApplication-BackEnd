package com.resilience.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.resilience.spring.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	@Query("select t from Transaction t  join t.customer c where c.customer_id= :id ")
	public List<Transaction> findTransactionsByCustomerId(@Param("id") int id);

}
