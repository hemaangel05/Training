package com.verizon.sba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.sba.dao.PlansReposiotry;
import com.verizon.sba.model.Plans;


@Service
public class PlansServiceImpl implements PlansService{
	
	@Autowired
	private PlansReposiotry planRepo;

	@Override
	public Plans getPlanById(long planId) {
		Plans plan = null;
		
		/*if(planRepo.existsById(planId)) {
			contact = planRepo.findById(planId).get();
		}*/
		
		Optional<Plans> optCon = planRepo.findById(planId);
		if(optCon.isPresent()) {
			plan = optCon.get();
		}
		return plan;
	}

	@Override
	public List<Plans> getAllPlans() {
		return planRepo.findAll();
	}

	@Override
	public Plans addPlan(Plans plan) {
		return planRepo.save(plan);
	}

	@Override
	public Plans updatePlan(Plans plan) {
		return planRepo.save(plan);
	}

	@Override
	public boolean deletePlan(long planId) {
		
		boolean isDeleted = false;
		if(planRepo.existsById(planId)) {
			planRepo.deleteById(planId);
			isDeleted = true;
		}
		return isDeleted;
		
	}

	@Override
	public List<Plans> findAllBySpeed(int speed) {
		return planRepo.findAllBySpeed(speed);
	}

	@Override
	public List<Plans> findAllByMaxUsage(int maxUsage) {
		return planRepo.findAllByMaxUsage(maxUsage);
	}

	@Override
	public List<Plans> findAllByPrice(double price) {
		return planRepo.findAllByPrice(price);
	}

}
