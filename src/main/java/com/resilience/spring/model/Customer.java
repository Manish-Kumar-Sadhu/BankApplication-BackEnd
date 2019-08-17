package com.resilience.spring.model;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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


@Entity
@Table
public class Customer {

	@Transient
	Date date =new Date();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss");
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name = "seq", initialValue = 1000001)
	@Column
	private int customer_id;
	
	@OneToMany
	@JoinColumn(name = "customer_id")
	Set<Account> emps = new HashSet<>();
	
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
	
	@Column
	private String creation_date = sdf.format(new Timestamp(date.getTime()));
	
	@Column(unique=true)
	private String aadhaar_card;
	
	@Column(unique=true)
	private String pan_card;
	
	@Column(unique=true)
	private String passport;
	
}
