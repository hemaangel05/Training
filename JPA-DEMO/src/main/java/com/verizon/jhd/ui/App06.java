package com.verizon.jhd.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.Gender;
import com.verizon.jhd.model.composition.Address;
import com.verizon.jhd.model.composition.Employee;
import com.verizon.jhd.model.composition.HallTicket;
import com.verizon.jhd.model.composition.Identification;
import com.verizon.jhd.util.JPAUtil;

public class App06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HallTicket ht = new HallTicket("12345","Hema Beesetti","Term",new Identification("photo_1","finger_1"));
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		em.persist(ht);
		
		
		txn.commit();

		System.out.println("Data persisted");
		JPAUtil.shutdown();
	}

}
