package com.verizon.jhd.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.isa.ContractEmployee;
import com.verizon.jhd.model.isa.Employee;
import com.verizon.jhd.model.isa.Manager;
import com.verizon.jhd.util.JPAUtil;

public class App05 {
	
	public static void main(String args[]) {
		
		Employee emp1 = new Employee(101,"Ram",75845);
		
		ContractEmployee cemp = new ContractEmployee(102,"Rave",4856,87);
		
		Manager mn = new Manager(103,"Sam",74586,5689);
		
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		
		em.persist(emp1);
		em.persist(cemp);
		em.persist(mn);
		
		txn.commit();
		
		JPAUtil.shutdown();
	}

}
