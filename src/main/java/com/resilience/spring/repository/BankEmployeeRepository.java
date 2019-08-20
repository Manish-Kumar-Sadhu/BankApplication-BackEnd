package com.resilience.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.resilience.spring.model.BankEmployee;

public interface BankEmployeeRepository extends JpaRepository<BankEmployee, Integer> {

	@Query("select b from BankEmployee b where b.email = :email")
	public BankEmployee findByEmail(@Param("email") String email);
}
