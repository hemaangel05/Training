package com.verizon.jhd.model.isa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("memp")

@Table(name="MEmpsOnly")

public class Manager extends Employee {
	
	private double allowance;
	
	public Manager() {
		
	}

	public Manager(int empId, String ename, double basic, double allowance) {
		super(empId, ename, basic);
		
		this.allowance = allowance;
	}
	
	

}
