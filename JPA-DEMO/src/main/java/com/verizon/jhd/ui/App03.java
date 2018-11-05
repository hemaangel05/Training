package com.verizon.jhd.ui;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.Gender;
import com.verizon.jhd.model.Person;
import com.verizon.jhd.model.composition.Address;
import com.verizon.jhd.model.composition.Employee;
import com.verizon.jhd.util.JPAUtil;

public class App03 {

	public static void main(String args[]) {
		Employee e = new Employee("Hema Beesetti", Gender.Feminine,LocalDate.of(1996, 10, 3),new Address("38-31-150","Visakhapatnam","AP"));
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		em.persist(e);
		
		
		txn.commit();

		System.out.println("Data persisted");
		JPAUtil.shutdown();

	}
	

}