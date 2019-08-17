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
	Set<Account> accounts = new HashSet<>();

	
}
