package com.resilience.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.resilience.spring.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {


	@Query("select c from Customer c where c.email = :email")
	public Customer findByEmail(@Param("email") String email);
	
	
}
