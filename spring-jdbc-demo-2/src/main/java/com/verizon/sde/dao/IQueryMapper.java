package com.verizon.sde.dao;

public interface IQueryMapper {
	public static final String INS_ITEM_QRY = 
			"INSERT INTO emps VALUES(:empId, :empName, :basic, :hra, :dept)";
	public static final String DEL_ITEM_QRY = 
			"DELETE FROM emps WHERE empid=:empId";
	public static final String UPD_ITEM_QRY = 
			"UPDATE emps SET ename=:empName, basic=:basic, hra=:hra, dept=:dept WHERE empid=:empId";
	public static final String GET_ITEM_QRY = 
			"SELECT * FROM emps WHERE empid=:empId";
	public static final String GET_ALL_ITEMS_QRY = 
			"SELECT *FROM emps";
}
