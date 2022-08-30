package com.multiclientweb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.multiclientweb.entity.Orders;

@Service

public interface OrderService {
	
	public Orders addOrder(Orders order);
	
	public Orders removeOrder(long orderId);

	public Orders updateOrder(long orderId,Orders order);
	
	public Orders getOrderDetails(long orderId);
	
	public List<Orders> getAllOrders();


}
