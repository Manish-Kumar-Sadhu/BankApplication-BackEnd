package com.resilience.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class TransactionType {

	@Id
	@Column
	@NotNull
	private int id;

	@NotNull
	@Column
	private String transaction_type;

	@OneToMany
	@JoinColumn(name = "transaction_type")
	Set<Transaction> transaction = new HashSet<>();

	public TransactionType() {
		super();
	}

	public TransactionType(@NotNull int id, @NotNull String transaction_type, Set<Transaction> transaction) {
		super();
		this.id = id;
		this.transaction_type = transaction_type;
		this.transaction = transaction;
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

	public Set<Transaction> getTransaction() {
		return transaction;
	}

}
