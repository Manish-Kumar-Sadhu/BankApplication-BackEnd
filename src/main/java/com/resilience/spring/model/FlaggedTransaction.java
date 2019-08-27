//package com.resilience.spring.model;
//
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
//public class FlaggedTransaction {
//
//	private int customer_id;
//
//	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
//	Calendar cal = Calendar.getInstance();
//	private Date creation_date = new Date(cal.getTimeInMillis());
//
//	private int amount;
//
//	public FlaggedTransaction() {
//		super();
//	}
//
//	public FlaggedTransaction(int customer_id, Date creation_date, int amount) {
//		super();
//		this.customer_id = customer_id;
//		this.creation_date = creation_date;
//		this.amount = amount;
//	}
//
//	public int getCustomer_id() {
//		return customer_id;
//	}
//
//	public void setCustomer_id(int customer_id) {
//		this.customer_id = customer_id;
//	}
//
//	public Date getCreation_date() {
//		return creation_date;
//	}
//
//	public void setCreation_date(Date creation_date) {
//		this.creation_date = creation_date;
//	}
//
//	public int getAmount() {
//		return amount;
//	}
//
//	public void setAmount(int amount) {
//		this.amount = amount;
//	}
//
//}
