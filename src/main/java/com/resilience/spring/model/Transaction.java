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

@Entity
@Table
public class Transaction {
	
	@Transient
	Date date = new Date();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss");

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqt")
	@SequenceGenerator(name = "seqt", initialValue = 5000001)
	@Column
	private int transaction_id;

	@ManyToOne
	@JoinColumn(name = "transactiontype")
	private TransactionType transactiontype;

	
	@Column
	private int from_acccount_number;
	@Column
	private int to_accounnt_number;
	@Column
	private String transaction_type;
	@Column
	// private Date timesstamp;
	private String timesstamp = sdf.format(new Timestamp(date.getTime()));

	public Transaction() {

	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
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

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getTimesstamp() {
		return timesstamp;
	}

	public void setTimesstamp(String timesstamp) {
		this.timesstamp = timesstamp;
	}

	public Transaction(int transaction_id, int from_acccount_number, int to_accounnt_number, String transaction_type,
			String timesstamp) {
		super();
		this.transaction_id = transaction_id;
		this.from_acccount_number = from_acccount_number;
		this.to_accounnt_number = to_accounnt_number;
		this.transaction_type = transaction_type;
		this.timesstamp = timesstamp;
	}

}
