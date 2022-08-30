package com.multiclientweb.repository;

import javax.persistence.JpaRepository;

import com.multiclientweb.entity.Orders;

public interface OrderRepository extends  JpaRepository<Orders,Long> {
	
	Orders findByOrderId(long orderId);

}
