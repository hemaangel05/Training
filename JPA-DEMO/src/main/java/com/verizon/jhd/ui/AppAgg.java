package com.verizon.jhd.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.onetoone.BankAccountAgg;
import com.verizon.jhd.model.onetoone.EmployeeAgg;
import com.verizon.jhd.util.JPAUtil;

public class AppAgg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeAgg emp = new EmployeeAgg(101,"Hema",657843);
		BankAccountAgg acc = new BankAccountAgg("SB001","SBI","SB0089");
		emp.setSalaryAccount(acc);
		acc.setAccountHolder(emp);
		
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		em.persist(emp);
		em.persist(acc);
		
		
		txn.commit();
		
		System.out.println("Data persisted");
		JPAUtil.shutdown();
		

	}

}
