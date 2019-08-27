package com.resilience.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.resilience.spring.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {


	@Query("select c from Customer c where c.email = :email")
	public Customer findByEmail(@Param("email") String email);

	@Query("SELECT count(u) FROM Customer u WHERE u.email=?1")
	int countUsersWithEmail(String myEmail);

	@Query("SELECT count(u) FROM Customer u WHERE u.aadhaar_card=?1")
	int countUsersWithAadhar(int myAadhar);

	@Query("SELECT count(u) FROM Customer u WHERE u.pan_card=?1")
	int countUsersWithPan(String myPan);

	@Query("SELECT count(u) FROM Customer u WHERE u.passport=?1")
	int countUsersWithpassport(String mypassport);

	@Query("SELECT count(u) FROM Customer u WHERE u.mobile_no=?1")
	int countUsersWithNumber(long mynumber);


	

	
}
