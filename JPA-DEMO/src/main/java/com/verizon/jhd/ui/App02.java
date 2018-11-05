package com.verizon.jhd.ui;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.Gender;
import com.verizon.jhd.model.Person;
import com.verizon.jhd.util.JPAUtil;

public class App02 {

	public static void main(String args[]) {
		Person p = new Person("Hema","B", Gender.Feminine, true,LocalDate.of(1996, 10, 31));
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		em.persist(p);
		
		
		txn.commit();

		System.out.println("Data persisted");
		JPAUtil.shutdown();

	}
	

}