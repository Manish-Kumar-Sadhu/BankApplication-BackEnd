package com.resilience.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class AccountType {

	@Id
	@Column
	@NotNull
	private int account_type_id;

	@Column
	@NotNull
	private String account_type;

	@JsonIgnoreProperties("accounts")
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "account_type_id")
	Set<Account> accounts = new HashSet<>();

	public AccountType() {
		super();
	}

	public AccountType(@NotNull int account_type_id, @NotNull String account_type) {
		super();
		this.account_type_id = account_type_id;
		this.account_type = account_type;
	}

	public AccountType(@NotNull int account_type_id, @NotNull String account_type, Set<Account> accounts) {
		super();
		this.account_type_id = account_type_id;
		this.account_type = account_type;
		this.accounts = accounts;
	}

	public int getAccount_type_id() {
		return account_type_id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

}
