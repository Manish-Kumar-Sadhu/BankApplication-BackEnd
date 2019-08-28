package com.resilience.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.resilience.spring.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	@Query("select t from Transaction t  join t.customer c where c.customer_id= :id ")
	public List<Transaction> findTransactionsByCustomerId(@Param("id") int id);

	@Query(value="select t.customer_id as CustomerID, t.creation_date as Date, sum(t.amount) as TotalAmount from Transaction t group by customer_id, creation_date having sum(amount)>10000", nativeQuery = true)
	public List findAllFlagged();
}
