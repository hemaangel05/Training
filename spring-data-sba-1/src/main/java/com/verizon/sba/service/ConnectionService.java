package com.verizon.sba.service;

import java.util.List;

import com.verizon.sba.model.Connection;


public interface ConnectionService {
	
	Connection getOrderById(long orderId);
	List<Connection> getAllOrders();
	Connection addOrder(Connection con);
	Connection updateOrder(Connection con);
	boolean deleteOrder(long orderId);

}
