package com.resilience.spring.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties
public class Customer {

	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", initialValue = 1000001)
	@Column
	private int customer_id;

	@JsonIgnoreProperties("accounts")
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	Set<Account> accounts = new HashSet<>();

	@JsonIgnoreProperties("transactions")
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	Set<Transaction> transactions = new HashSet<>();

	@NotNull
	@Column
	private String password;


	@Column(columnDefinition = "integer default 0")
	private int customer_status;

	@NotNull
	@Column
	private String first_name;

	@NotNull
	@Column
	private String last_name;

	@NotNull
	@Column(unique = true)
	private String email;

	@NotNull
	@Column(unique = true)
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
	// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	// private String creation_date = sdf.format(new Date(cal.getTimeInMillis()));
	private Date creation_date = new Date(cal.getTimeInMillis());

	@NotNull
	@Column(unique = true)
	private long aadhaar_card;

	@NotNull
	@Column(unique = true)
	private String pan_card;

	@Column(unique = true, columnDefinition = "varchar(10) default 'NA'")
	private String passport = "NA";


	@JsonIgnore
	@Column(columnDefinition = "varchar(255) default 'CUST'")
	private String role = "CUST";

	public Customer() {
		super();
	}

	public Customer(@NotNull int customer_id, Set<Account> accounts, Set<Transaction> transactions,
			@NotNull String password, @NotNull int customer_status, @NotNull String first_name,
			@NotNull String last_name, @NotNull String email, @NotNull long mobile_no, String house_no, String street,
			String district, String state, @NotNull Date creation_date, @NotNull long aadhaar_card,
			@NotNull String pan_card, String passport, @NotNull String role) {
		super();
		this.customer_id = customer_id;
		this.accounts = accounts;
		this.transactions = transactions;
		this.password = password;
		this.customer_status = customer_status;
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
		this.role = role;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCustomer_status() {
		return customer_status;
	}

	public void setCustomer_status(int customer_status) {
		this.customer_status = customer_status;
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

	public long getAadhaar_card() {
		return aadhaar_card;
	}

	public void setAadhaar_card(long aadhaar_card) {
		this.aadhaar_card = aadhaar_card;
	}

	public String getPan_card() {
		return pan_card;
	}

	public void setPan_card(String pan_card) {
		this.pan_card = pan_card;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

}
