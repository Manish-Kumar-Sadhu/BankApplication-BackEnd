package com.resilience.spring.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqa")
	@SequenceGenerator(name = "seqa", initialValue = 9000001)
	@Column
	@NotNull
	private int account_no;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "customer_id")
	private Customer customer;

//	@NotNull
//	@Column
//	private int customer_id;

	@Column(columnDefinition = "integer default 10000")
	@NotNull
	private int balance = 10000;

	@Transient
	@JsonIgnore
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

	@Transient
	@JsonIgnore
	Calendar cal = Calendar.getInstance();

	@Column
	private Date creation_date = new Date(cal.getTimeInMillis());

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "account_type_id")
	private AccountType accountType;

	@NotNull
	@Column(columnDefinition = "integer default 0")
	private int account_status;

	public Account() {
		super();
	}

	public Account(@NotNull int account_no, @NotNull Customer customer, @NotNull int balance,
			@NotNull Date creation_date, AccountType accountType, @NotNull short account_status) {
		super();
		this.account_no = account_no;
		this.customer = customer;
		this.balance = balance;
		this.creation_date = creation_date;
		this.accountType = accountType;
		this.account_status = account_status;
	}

	public int getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer currentCustomer) {
		this.customer = currentCustomer;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public int getAccount_status() {
		return account_status;
	}

	public void setAccount_status(int account_status) {
		this.account_status = account_status;
	}

//	public int getCustomer_id() {
//		return customer_id;
//	}
//
//	public void setCustomer_id(int customer_id) {
//		this.customer_id = customer_id;
//	}

}
