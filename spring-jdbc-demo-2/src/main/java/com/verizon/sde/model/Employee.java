package com.verizon.sde.model;

public class Employee {
	
	private int empId;
	private String empName;
	private double basic;
	private double hra;
	private String dept;
	public Employee() {
		super();
	}
	public Employee(int empId, String empName, double basic, double hra, String dept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.basic = basic;
		this.hra = hra;
		this.dept = dept;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", basic=" + basic + ", hra=" + hra + ", dept="
				+ dept + "]";
	}
	
	

}
