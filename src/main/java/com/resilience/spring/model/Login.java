package com.resilience.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
	
	@Id
	private String email;
	
	private String password;
	
	private String type;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getType() {
		return type;
	}
	
}
