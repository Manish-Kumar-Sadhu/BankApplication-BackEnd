package com.resilience.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Bank {

	@Id
	@Column
	private int bank_id;
	
	@Column
	private String bank_name;
	
	@Column
	private String ifsc_code;
	
	@Column
	private String address;
	
	@Column
	private String district;
	
	@Column
	private String state;
	
	@Column
	private int pincode;

	public Bank() {
		super();
	}

	public Bank(int bank_id, String bank_name, String ifsc_code, String address, String district, String state,
			int pincode) {
		super();
		this.bank_id = bank_id;
		this.bank_name = bank_name;
		this.ifsc_code = ifsc_code;
		this.address = address;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}

	public int getBank_id() {
		return bank_id;
	}


	public String getBank_name() {
		return bank_name;
	}


	public String getIfsc_code() {
		return ifsc_code;
	}



	public String getAddress() {
		return address;
	}



	public String getDistrict() {
		return district;
	}



	public String getState() {
		return state;
	}



	public int getPincode() {
		return pincode;
	}


	
	
}
