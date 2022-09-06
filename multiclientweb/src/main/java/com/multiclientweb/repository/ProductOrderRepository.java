package com.multiclientweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiclientweb.entity.ProductOrder;



public interface ProductOrderRepository  extends JpaRepository<ProductOrder,Long>{

}
