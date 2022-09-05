package com.multiclientweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiclientweb.entity.ProductMgmt;

public interface ProductMgmtRepository extends JpaRepository<ProductMgmt, Integer>
{

	ProductMgmt findByProductName(String productName);


}
