package com.verizon.jhd.model.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employeesagg1")
public class EmployeeAgg {

	@Id
	private int empId;
	private String ename;
	private double basic;
	
	@OneToOne(mappedBy="accountHolder",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private BankAccountAgg salaryAccount;
	
	public EmployeeAgg() {
		
	}

	public EmployeeAgg(int empId, String ename, double basic) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.basic = basic;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public BankAccountAgg getSalaryAccount() {
		return salaryAccount;
	}

	public void setSalaryAccount(BankAccountAgg salaryAccount) {
		this.salaryAccount = salaryAccount;
	}
	
	
}
