package com.resilience.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.resilience.spring.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.email = :email and c.customer_status = 1")
	public Customer findByEmail(@Param("email") String email);


	@Query("SELECT count(u) FROM Customer u WHERE u.email=?1")
	int countUsersWithEmail(String myEmail);

	@Query("SELECT count(u) FROM Customer u WHERE u.aadhaar_card=?1")
	int countUsersWithAadhar(long myAadhar);

	@Query("SELECT count(u) FROM Customer u WHERE u.pan_card=?1")
	int countUsersWithPan(String myPan);

	@Query("SELECT count(u) FROM Customer u WHERE u.passport=?1")
	int countUsersWithpassport(String mypassport);

	@Query("SELECT count(u) FROM Customer u WHERE u.mobile_no=?1")
	int countUsersWithNumber(long mynumber);


	


	//.customer_id, c.first_name, c.last_name, c.email, c.mobile_no
	@Query("select c from Customer c where c.customer_status = 0")
	public List<Customer> findInactiveCustomers();

	
	
	@Query("select c from Customer c where c.customer_id = :customer_id and c.customer_status = 1")
	public Optional<Customer> findCustomer(@PathVariable("customer_id") int customer_id);
	
	@Query("select c from Customer c where c.customer_status = 1")
	public Page<Customer> findAll(Pageable pageable);
}
