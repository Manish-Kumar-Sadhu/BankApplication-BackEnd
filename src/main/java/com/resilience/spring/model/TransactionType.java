package com.resilience.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TransactionType {
	
	@Id
	@Column
	private int id;
	
	@Column(name = "TRANSACTION_TYPE")
	private String type;
	
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
