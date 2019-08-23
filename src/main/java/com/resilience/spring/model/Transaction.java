package com.resilience.spring.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
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

	@ManyToOne
	@JoinColumn(name = "transaction_type")
	private TransactionType transaction_type;

	@NotNull
	@Column
	private int from_acccount_number;

	@Column
	private int to_accounnt_number;

	@NotNull
	@Column
	private int amount;

//	@NotNull
//	@Column
//	private String transaction_type;

	@NotNull
	@Column
	private Date creation_date = new Date(cal.getTimeInMillis());

	@Column
	private String description;

	public Transaction() {
		super();
	}

	public Transaction(@NotNull int transaction_id, Customer customer, TransactionType transaction_type,
			@NotNull int from_acccount_number, int to_accounnt_number, @NotNull Date creation_date) {
		super();
		this.transaction_id = transaction_id;
		this.customer = customer;
		this.transaction_type = transaction_type;
		this.from_acccount_number = from_acccount_number;
		this.to_accounnt_number = to_accounnt_number;
		this.creation_date = creation_date;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public TransactionType getTransaction_type() {
		return transaction_type;
	}

	public void setTransactiontype(TransactionType transaction_type) {
		this.transaction_type = transaction_type;
	}

	public int getFrom_acccount_number() {
		return from_acccount_number;
	}

	public void setFrom_acccount_number(int from_acccount_number) {
		this.from_acccount_number = from_acccount_number;
	}

	public int getTo_accounnt_number() {
		return to_accounnt_number;
	}

	public void setTo_accounnt_number(int to_accounnt_number) {
		this.to_accounnt_number = to_accounnt_number;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setTransaction_type(TransactionType transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
