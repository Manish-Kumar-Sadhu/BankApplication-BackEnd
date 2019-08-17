package com.resilience.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class AccountType {
	
	@Id
	@Column
	private int account_type_id;
	
	@Column
	
	private String account_type;
	
	@OneToMany
	@JoinColumn(name = "account_type_id")
<<<<<<< HEAD
	Set<Account> accountTypes = new HashSet<>();
=======
	Set<Account> accounts = new HashSet<>();
>>>>>>> b0a151db047c4672b1a42bced6cd5df31656d0d8

	
}
