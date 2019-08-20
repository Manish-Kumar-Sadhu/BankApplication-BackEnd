package com.resilience.spring.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class BankEmployee {
	
	@Transient
	@JsonIgnore
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	
	@Transient
	@JsonIgnore
	Calendar cal = Calendar.getInstance();
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqb")
	@SequenceGenerator(name = "seqb", initialValue = 3000001)
	@Column
	private int employee_id;

	@Column
	private String first_name;

	@Column
	private String last_name;

	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private int mobile_no;

	@Column
	private String house_no;

	@Column
	private String street;

	@Column
	private String district;

	@Column
	private String state;

	@Column
    private String pan_card;

	//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	//private String creation_date = sdf.format(new Date(cal.getTimeInMillis()));
    private Date creation_date = new Date(cal.getTimeInMillis());
	
//	@Column
//	// private Date created_date;
//	private String created_date = sdf.format(new Timestamp(date.getTime()));

	@Column
	private String password;

	@Column(unique = true)
	private int aadhar_card;



	@Column(unique = true)
	private String passport;

	@Column
	private Date job_start_date;

	@Column
	private Date job_end_date;

	@Column
	private Boolean employee_status;

	@Column
	private String employee_designation;

	public BankEmployee() {
		
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
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

	public int getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(int mobile_no) {
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

	public String getPan_card() {
		return pan_card;
	}

	public void setPan_card(String pan_card) {
		this.pan_card = pan_card;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAadhar_card() {
		return aadhar_card;
	}

	public void setAadhar_card(int aadhar_card) {
		this.aadhar_card = aadhar_card;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public Date getJob_start_date() {
		return job_start_date;
	}

	public void setJob_start_date(Date job_start_date) {
		this.job_start_date = job_start_date;
	}

	public Date getJob_end_date() {
		return job_end_date;
	}

	public void setJob_end_date(Date job_end_date) {
		this.job_end_date = job_end_date;
	}

	public Boolean getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(Boolean employee_status) {
		this.employee_status = employee_status;
	}

	public String getEmployee_designation() {
		return employee_designation;
	}

	public void setEmployee_designation(String employee_designation) {
		this.employee_designation = employee_designation;
	}

	public BankEmployee(SimpleDateFormat sdf, Calendar cal, int employee_id, String first_name, String last_name,
			String email, int mobile_no, String house_no, String street, String district, String state, String pan_card,
			Date creation_date, String password, int aadhar_card, String passport, Date job_start_date,
			Date job_end_date, Boolean employee_status, String employee_designation) {
		super();
		this.sdf = sdf;
		this.cal = cal;
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.mobile_no = mobile_no;
		this.house_no = house_no;
		this.street = street;
		this.district = district;
		this.state = state;
		this.pan_card = pan_card;
		this.creation_date = creation_date;
		this.password = password;
		this.aadhar_card = aadhar_card;
		this.passport = passport;
		this.job_start_date = job_start_date;
		this.job_end_date = job_end_date;
		this.employee_status = employee_status;
		this.employee_designation = employee_designation;
	}
	
	
	

}