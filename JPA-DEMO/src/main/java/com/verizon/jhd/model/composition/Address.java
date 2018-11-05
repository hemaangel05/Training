package com.verizon.jhd.model.composition;


import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String doorNumber;
	private String city;
	private String state;
	
	public Address() {
		
	}

	public Address(String doorNumber, String city, String state) {
		super();
		this.doorNumber = doorNumber;
		this.city = city;
		this.state = state;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [doorNumber=" + doorNumber + ", city=" + city + ", state=" + state + "]";
	}
	
	

}
