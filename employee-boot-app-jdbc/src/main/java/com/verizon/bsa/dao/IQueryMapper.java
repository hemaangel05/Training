package com.verizon.bsa.dao;

public interface IQueryMapper {
	
	public static final String INS_BOOK_QRY = 
			"INSERT INTO employees VALUES(?,?,?,?,?)";
	public static final String DEL_BOOK_QRY = 
			"DELETE FROM employees WHERE eid=?";
	public static final String UPDATE_BOOK_QRY = 
			"UPDATE employees SET name=?,basic=?,hra=?,dept=? WHERE eid=?";
	public static final String GET_BOOK_QRY = 
			"SELECT * FROM employees WHERE eid=?";
	public static final String GET_ALL_BOOK_QRY = 
			"SELECT * FROM employees";
}
