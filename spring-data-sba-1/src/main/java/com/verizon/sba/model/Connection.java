package com.verizon.sba.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="connections")
public class Connection {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderid;
	
	@NotEmpty(message="Name can not be empty")
	@Size(min=3,max=15,message="firstName must be of 3 to 15 chars")
	private String customerName;
	
	@NotEmpty(message="Plan Title can't be empty")
	@Column(name="p_title")
	private String pTitle;
	
	@NotEmpty(message="Mobile Number can not be empty")
	@Pattern(regexp="\\d{10}",message="mobile number can be only 10 digits")
	@Column(name="mno")
	private String mobileNumber;
	
	@NotEmpty(message="Address can not be empty")
	@Column(name="address")
	private String address;
	
	@NotEmpty(message="time slot must not be empty")
	@Column(name="time_slot")
	private String timeSlot;
	
	@DateTimeFormat(iso=ISO.DATE)
	@NotNull(message="Date Of Birth can not be left blank")
	@Column(name="dor")
	private LocalDate dateOfRequest;

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public LocalDate getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(LocalDate dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}
	
	
	
	
	

}
