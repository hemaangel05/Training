package com.verizon.sba.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plans")
public class Plans {
	
	@Id 
	@Column(name="p_title")
	private String pTitle;
	
	private int speed;
	
	@Column(name="max_usage")
	private int maxUsage;
	
	@Column(name="charge")
	private double price;

	

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	

	public int getMaxUsage() {
		return maxUsage;
	}

	public void setMaxUsage(int maxUsage) {
		this.maxUsage = maxUsage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
