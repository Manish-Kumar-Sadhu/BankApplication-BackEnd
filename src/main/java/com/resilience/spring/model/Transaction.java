package com.resilience.spring.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
@Table
public class Transaction {

	@Transient
	@JsonIgnore
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

	@Transient
	@JsonIgnore
	Calendar cal = Calendar.getInstance();

	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqt")
	@SequenceGenerator(name = "seqt", initialValue = 5000001)
	@Column
	private int transaction_id;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "customer_id")
	private Customer customer;

//	@ManyToOne
//	@Transient
//	@JsonIgnore
//	@JoinColumn(name = "transaction_type")
//	private TransactionType transaction_type;

	@NotNull
	@Column
	private int from_account_number;

	@NotNull
	@Column
	private int to_account_number;

	@NotNull
	@Column
	private int amount;

//	@NotNull
//	@Column
//	private String transaction_type;

	@Column
	private Date creation_date = new Date(cal.getTimeInMillis());

	@Column(columnDefinition = "varchar(255) default 'No Description'")
	private String description = "No Description";

	public Transaction() {
		super();
	}

	public Transaction(@NotNull int transaction_id, Customer customer, @NotNull int from_account_number,
			@NotNull int to_account_number, @NotNull int amount, Date creation_date, String description) {
		super();
		this.transaction_id = transaction_id;
		this.customer = customer;
		this.from_account_number = from_account_number;
		this.to_account_number = to_account_number;
		this.amount = amount;
		this.creation_date = creation_date;
		this.description = description;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getFrom_account_number() {
		return from_account_number;
	}

	public void setFrom_account_number(int from_account_number) {
		this.from_account_number = from_account_number;
	}

	public int getTo_account_number() {
		return to_account_number;
	}

	public void setTo_account_number(int to_account_number) {
		this.to_account_number = to_account_number;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}