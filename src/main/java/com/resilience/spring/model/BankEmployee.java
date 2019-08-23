package com.resilience.spring.model;

import java.sql.Date;
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
import javax.validation.constraints.NotNull;

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

	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqb")
	@SequenceGenerator(name = "seqb", initialValue = 3000001)
	@Column
	private int employee_id;

	@NotNull
	@Column
	private String first_name;

	@NotNull
	@Column
	private String last_name;

	@NotNull
	@Column(unique = true)
	private String email;

	@NotNull
	@Column(unique = true)
	private long mobile_no;

	@Column
	private String house_no;

	@Column
	private String street;

	@Column
	private String district;

	@Column
	private String state;

	@NotNull
	@Column
	private String pan_card;

	// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	// private String creation_date = sdf.format(new Date(cal.getTimeInMillis()));
	@NotNull
	@Column
	private Date creation_date = new Date(cal.getTimeInMillis());

//	@Column
//	// private Date created_date;
//	private String created_date = sdf.format(new Timestamp(date.getTime()));

	@NotNull
	@Column
	private String password;

	@NotNull
	@Column(unique = true)
	private long aadhar_card;

	@Column(unique = true)
	private String passport;

	@NotNull
	@Column
	private Date job_start_date = new Date(cal.getTimeInMillis());

	@NotNull
	@Column
	private int employee_status;

	@Column(columnDefinition = "varchar(255) default 'EMP'")
	@NotNull
	private String employee_role;

	public BankEmployee() {
		super();
	}

	public BankEmployee(@NotNull int employee_id, @NotNull String first_name, @NotNull String last_name,
			@NotNull String email, @NotNull long mobile_no, String house_no, String street, String district,
			String state, @NotNull String pan_card, @NotNull Date creation_date, @NotNull String password,
			@NotNull long aadhar_card, String passport, @NotNull Date job_start_date, @NotNull short employee_status,
			@NotNull String employee_role) {
		super();
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
		this.employee_status = employee_status;
		this.employee_role = employee_role;
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

	public long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(long mobile_no) {
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

	public long getAadhar_card() {
		return aadhar_card;
	}

	public void setAadhar_card(long aadhar_card) {
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

	public int getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(short employee_status) {
		this.employee_status = employee_status;
	}

	public String getEmployee_role() {
		return employee_role;
	}

	public void setEmployee_role(String employee_designation) {
		this.employee_role = employee_designation;
	}

}