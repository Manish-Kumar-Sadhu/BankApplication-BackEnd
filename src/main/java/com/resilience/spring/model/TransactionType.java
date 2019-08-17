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
public class TransactionType {
	
	@Id
	@Column
	private int id;
	
	@Column
	private String type;
	@OneToMany
	@JoinColumn(name = "type")
	Set<Transaction> transaction = new HashSet<>();
	
	
	
	public TransactionType() {
		
	}

	public int getId() {
		return id;
	}

	

	public String getType() {
		return type;
	}

	

	public TransactionType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	
	
	

}
