package com.resilience.spring.model;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Transaction {
	  @Transient
	  Date date =new Date();
	  private static final SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss");
	
	@Id
	@Column
	private int transaction_id;
	@Column
    private int from_acccount_number;
	@Column	
    private int to_accounnt_number;
	@Column
    private String transaction_type;
	@Column
    private Date timesstamp;
	
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
	public Date getTimesstamp() {
		return timesstamp;
	}
	public void setTimesstamp(Date timesstamp) {
		this.timesstamp = timesstamp;
	}
	
	
	public Transaction(int transaction_id, int from_acccount_number, int to_accounnt_number, String transaction_type,
			Date timesstamp) {
		super();
		this.transaction_id = transaction_id;
		this.from_acccount_number = from_acccount_number;
		this.to_accounnt_number = to_accounnt_number;
		this.transaction_type = transaction_type;
		this.timesstamp = timesstamp;
	}
	
	

}