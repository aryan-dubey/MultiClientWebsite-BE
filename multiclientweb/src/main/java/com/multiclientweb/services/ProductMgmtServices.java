package com.multiclientweb.services;

import org.springframework.stereotype.Service;

import com.multiclientweb.entity.ProductMgmt;
import com.multiclientweb.repository.ProductMgmtRepository;


@Service
public class ProductMgmtServices {

	public boolean add(ProductMgmt productmgmt, int vendorId) {
		ProductMgmt pm = ProductMgmtRepository.findByProductName(productmgmt.getProductName());

//		Customer cust = customerRepository.findById(customerId).get();
//		if (cust == null) {
//			throw new ResourceNotFoundException("User not found ");
//		} else if (cust.gettype().equals("user")) {
//			throw new NotAdminException("Access Denied");
//		}
		if (pm == null) {
			ProductMgmtRepository.save(productmgmt);
			return true;
		} else {
			System.out.println("Product already exist");
			return false;
		}
	}

}