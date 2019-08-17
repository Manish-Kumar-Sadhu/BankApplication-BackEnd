package com.resilience.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resilience.spring.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
