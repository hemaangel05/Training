package com.verizon.sba.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.verizon.sba.model.Plans;

public interface PlansReposiotry extends JpaRepository<Plans,Long>{

	List<Plans> findAllBySpeed(int speed);
	List<Plans> findAllByMaxUsage(int maxUsage);
	List<Plans> findAllByPrice(double price);
	

}
