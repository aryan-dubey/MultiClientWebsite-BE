package com.multiclientweb.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiclientweb.entity.Orders;
import com.multiclientweb.exceptions.OrderNotFoundException;
import com.multiclientweb.repository.OrderRepository;
import com.multiclientweb.services.OrderService;

public class OrderServiceImpl implements OrderService{

private static final Logger log =LoggerFactory.getLogger(OrderService.class);
	
	//@Autowired annotation is used for dependency injection.In spring boot application, all loaded beans are eligible for auto wiring to another bean
	@Autowired
	OrderRepository orderRepository;
	

	
	@Override
	public Orders addOrder(Orders order) {
		log.info("Inside addOrder Service");
		orderRepository.save(order);
		return order;
	}

	@Override
	public Orders removeOrder(long orderId) {
		log.info("Inside removeOrder Service");
		Orders o=orderRepository.findByOrderId(orderId);
		if(o==null) {
			throw new OrderNotFoundException("Order with Id "+orderId+" does not exist.");
		}
		orderRepository.delete(o);
		return o;
	}

	@Override
	public Orders updateOrder(long orderId,Orders order) {
//		log.info("Inside updateOrder Service");
//		//Orders o2=orderRepo.findById(orderId).get();
//		orderRepo.save(order);
//		return order;
		
        Optional<Orders> order2 = orderRepository.findByOrderId(orderId);
        if(order2.isPresent()) {
        	System.out.println(orderId);
        	Orders o=order2.get();
        	o.setAmount(order.getAmount());
        	o.setBillDate(order.getBillDate());
        	o.setPaymentMethod(order.getPaymentMethod());
        	System.out.println(o);
        	orderRepository.save(o);
        }
               // .orElseThrow(() -> new ProductNotFoundException("Product with this id is not found"));
        
        return order;
	}

	@Override
	public Orders getOrderDetails(long orderId) {
		log.info("Inside getOrderDetails Service");
		Orders o1=orderRepository.findByOrderId(orderId);
		if(o1==null) {
			throw new OrderNotFoundException("Order with Id "+orderId+" does not exist.");
		}
		return o1;
	}

	@Override
	public List<Orders> getAllOrders() {
		//Log.info("Inside get detail");
		return orderRepository.findAll();
	}

}

}
