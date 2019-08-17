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
	private int id;
	
	@Column
	private String account_type;
	
	@OneToMany
	@JoinColumn(name = "account_type")
	Set<Account> accountTypes = new HashSet<>();

	public AccountType() {
		super();
	}

	public AccountType(int id, String account_type, Set<Account> accountTypes) {
		super();
		this.id = id;
		this.account_type = account_type;
		this.accountTypes = accountTypes;
	}

	public int getId() {
		return id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public Set<Account> getAccountTypes() {
		return accountTypes;
	}

	
	
	
}
