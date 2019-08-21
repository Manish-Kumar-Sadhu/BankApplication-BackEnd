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

	
	
	public AccountType() {
	}

	public int getAccount_type_id() {
		return account_type_id;
	}

	public void setAccount_type_id(int account_type_id) {
		this.account_type_id = account_type_id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public AccountType(int account_type_id, String account_type, Set<Account> accounts) {
		super();
		this.account_type_id = account_type_id;
		this.account_type = account_type;
		this.accounts = accounts;
	}

	
	
}
