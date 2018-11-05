package com.verizon.jhd.model.composition;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.verizon.jhd.model.Gender;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	@Column(name="ename",nullable=false)
	private String empName;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name="dob")
	private LocalDate dateofbirth;
	@Embedded
	private Address address;
	
	public Employee() {
		
	}

	public Employee(String empName, Gender gender, LocalDate dateofbirth, Address address) {
		super();
		this.empName = empName;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.address = address;
	}
	
	

}
