package com.verizon.sba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.sba.model.Connection;

@Repository
public interface ConnectionRepository  extends JpaRepository<Connection,Long>{
	
	

}
