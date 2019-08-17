package com.resilience.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AccountType {
	
	@Id
	@Column
	private int id;
	
	@Column(name="ACCOUNT_TYPE")
	private String type;
	
	public AccountType() {
		
	}

	public int getId() {
		return id;
	}

	

	public String getType() {
		return type;
	}

	
	public AccountType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	

}
