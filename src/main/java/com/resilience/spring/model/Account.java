package com.resilience.spring.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@Table
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqa")
	@SequenceGenerator(name = "seqa", initialValue = 9000001)
	@Column
	private int account_no;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column
	private int balance;

	@Transient
	Date date = new Date();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss");
	@Column
	private String creation_date = sdf.format(new Timestamp(date.getTime()));
	
	//@Column
	//private String account_type;
	
	@ManyToOne
	@JoinColumn(name = "account_type_id")
	//@Column(columnDefinition = "insert=false update=false")
	private AccountType accountType;
	
	@Column
	private boolean account_status;

	public Account() {
		super();
	}

	public Account(int account_no, Customer customer, int balance, Date date, String creation_date,
			AccountType accountType, boolean account_status) {
		super();
		this.account_no = account_no;
		this.customer = customer;
		this.balance = balance;
		this.date = date;
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

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public boolean isAccount_status() {
		return account_status;
	}

	public void setAccount_status(boolean account_status) {
		this.account_status = account_status;
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	
}
