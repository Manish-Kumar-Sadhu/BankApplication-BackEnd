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
public class TransactionType {

	@Id
	@Column
	@NotNull
	private int id;

	@NotNull
	@Column(unique = true)
	private String transaction_type;

	@JsonIgnoreProperties("transactions")
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction_type")
	Set<Transaction> transactions = new HashSet<>();

	public TransactionType() {
		super();
	}

	public TransactionType(@NotNull int id, @NotNull String transaction_type, Set<Transaction> transactions) {
		super();
		this.id = id;
		this.transaction_type = transaction_type;
		this.transactions = transactions;
	}

	public TransactionType(@NotNull int id, @NotNull String transaction_type) {
		super();
		this.id = id;
		this.transaction_type = transaction_type;
	}

	public int getId() {
		return id;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

}
