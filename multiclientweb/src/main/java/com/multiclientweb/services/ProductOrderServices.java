package com.multiclientweb.services;

import java.util.List;

import com.multiclientweb.entity.ProductOrder;



public interface ProductOrderServices {
	ProductOrder saveOrder(ProductOrder order);
	List<ProductOrder> getAllOrders();
	ProductOrder getOrderById(long id);
	ProductOrder updateOrder(ProductOrder order, long id);
	void deleteOrder(long id);
}
