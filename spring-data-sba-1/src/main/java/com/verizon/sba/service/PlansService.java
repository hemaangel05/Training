package com.verizon.sba.service;

import java.util.List;

import com.verizon.sba.model.Plans;

public interface PlansService  {

	Plans getPlanById(String string);
	List<Plans> getAllPlans();
	Plans addPlan(Plans plan);
	Plans updatePlan(Plans plan);
	boolean deletePlan(long planId);
	
	List<Plans> findAllBySpeed(int speed);
	List<Plans> findAllByMaxUsage(int maxUsage);
	List<Plans> findAllByPrice(double price);
	
}
