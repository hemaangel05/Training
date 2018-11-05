package com.verizon.edb.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.verizon.edb.model.Department;

@Entity
@Table(name="emps")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long empId;
	
	@NotEmpty(message="empName can not be empty")
	@Size(min=3,max=15,message="empName must be of 3 to 15 chars")
	private String empName;
	
	@NotNull(message="basic can not be empty")
	private double basic;
	
	@NotNull(message="hra can not be empty")
	private double hra;
	
	@NotEmpty(message="empName can not be empty")
	@Size(min=3,max=15,message="empName must be of 3 to 15 chars")
	private String department;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	
	
	
	
}
