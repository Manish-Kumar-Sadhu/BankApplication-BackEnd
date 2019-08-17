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
	@JoinColumn(name = "account_type")
	//@Column(columnDefinition = "insert=false update=false")
	private AccountType accountType;
	
	@Column
	private boolean account_status;

}
