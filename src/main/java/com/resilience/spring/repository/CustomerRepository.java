package com.resilience.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resilience.spring.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	
	public Customer findByEmail();
//	public static String verifyLogin(String email, String password)
//	{		
//		Customer customer;
//		String mail = customer.getEmail();
//		String pass = customer.getPassword();
//		
//		if(mail == email && pass == password)
//		{
//			return "exist";
//		}
//		else 
//			return "not exist";
//	}
}
