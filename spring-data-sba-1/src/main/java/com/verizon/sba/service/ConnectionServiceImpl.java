package com.verizon.sba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.verizon.sba.dao.ConnectionRepository;
import com.verizon.sba.model.Connection;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	@Autowired
	private ConnectionRepository conRepo;

	
	@Override
	public Connection getOrderById(long orderId) {
		Connection con = null;
		
		/*if(conRepo.existsById(orderId)) {
			contact = conRepo.findById(orderId).get();
		}*/
		
		Optional<Connection> optCon = conRepo.findById(orderId);
		if(optCon.isPresent()) {
			con = optCon.get();
		}
		return con;
		
	}

	@Override
	public List<Connection> getAllOrders() {
		return conRepo.findAll();
	}

	@Override
	public Connection addOrder(Connection con) {
		return conRepo.save(con);
	}

	@Override
	public Connection updateOrder(Connection con) {
		return conRepo.save(con);
	}

	@Override
	public boolean deleteOrder(long orderId) {
		boolean isDeleted = false;
		if(conRepo.existsById(orderId)) {
			conRepo.deleteById(orderId);
			isDeleted = true;
		}
		return isDeleted;
	}

	

}
