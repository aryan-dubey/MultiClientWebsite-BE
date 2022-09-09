package com.multiclientweb.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.multiclientweb.entity.ProductOrder;
import com.multiclientweb.exceptions.OrderNotFoundException;
import com.multiclientweb.repository.ProductOrderRepository;
import com.multiclientweb.services.ProductOrderServices;



@Service
public class ProductOrderServiceImpl implements ProductOrderServices {
	
	
	private ProductOrderRepository productOrderRepository;
	
	
	public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository) {
		super();
		this.productOrderRepository = productOrderRepository;
	}

	@Override
	public ProductOrder saveOrder(ProductOrder order) {
		return productOrderRepository.save(order);
	}

	@Override
	public List<ProductOrder> getAllOrders() {
		return productOrderRepository.findAll();
	}

	@Override
	public ProductOrder getOrderById(long id) {
		return productOrderRepository.findById(id).orElseThrow(()->
		new OrderNotFoundException("Order", "Id", id));
	}

	@Override
	public ProductOrder updateOrder(ProductOrder order, long id) {
		// we need to check whether employee with given id is exist in DB or not
				ProductOrder existingOrder = productOrderRepository.findById(id).orElseThrow(
						() -> new OrderNotFoundException("Order", "Id", id)); 
				
				existingOrder.setAmount(order.getAmount());
				existingOrder.setBillDate(order.getBillDate());
				existingOrder.setPaymentMethod(order.getPaymentMethod());
				// save existing employee to DB
				productOrderRepository.save(existingOrder);
				return existingOrder;
	}

	@Override
	public void deleteOrder(long id) {
		productOrderRepository.findById(id).orElseThrow(() -> 
		new OrderNotFoundException("Order", "Id", id));
		productOrderRepository.deleteById(id);

	}

}
