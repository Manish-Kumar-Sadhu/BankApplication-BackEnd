package com.resilience.spring.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name = "seq", initialValue = 1000001)
	@Column
	private int customer_id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	Set<Account> accounts = new HashSet<>();
	
	@Column
	private String password;
	
	@Column
	private String first_name;
	
	@Column
	private String last_name;
	
	@Column(unique=true)
	private String email;
	
	@Column(unique=true)
	private long mobile_no;
	
	@Column
	private String house_no;
	
	@Column
	private String street;
	
	@Column
	private String district;
	
	@Column
	private String state;
	
	@Transient
	@JsonIgnore
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	
	@Transient
	@JsonIgnore
	Calendar cal = Calendar.getInstance();
	
	@Column
	//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	//private String creation_date = sdf.format(new Date(cal.getTimeInMillis()));
    private Date creation_date = new Date(cal.getTimeInMillis());
    
	@Column(unique=true)
	private int aadhaar_card;
	
	@Column(unique=true)
	private int pan_card;
	
	@Column(unique=true)
	private String passport;

	
	public Customer() {
		super();
	}


	public Customer(int customer_id, String password, String first_name, String last_name, String email, long mobile_no,
			String house_no, String street, String district, String state, Date creation_date, int aadhaar_card,
			int pan_card, String passport) {
		super();
		this.customer_id = customer_id;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.mobile_no = mobile_no;
		this.house_no = house_no;
		this.street = street;
		this.district = district;
		this.state = state;
		this.creation_date = creation_date;
		this.aadhaar_card = aadhaar_card;
		this.pan_card = pan_card;
		this.passport = passport;
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getMobile_no() {
		return mobile_no;
	}


	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}


	public String getHouse_no() {
		return house_no;
	}


	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public Date getCreation_date() {
		return creation_date;
	}


	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}


	public int getAadhaar_card() {
		return aadhaar_card;
	}


	public void setAadhaar_card(int aadhaar_card) {
		this.aadhaar_card = aadhaar_card;
	}


	public int getPan_card() {
		return pan_card;
	}


	public void setPan_card(int pan_card) {
		this.pan_card = pan_card;
	}


	public String getPassport() {
		return passport;
	}


	public void setPassport(String passport) {
		this.passport = passport;
	}
	
	
}
