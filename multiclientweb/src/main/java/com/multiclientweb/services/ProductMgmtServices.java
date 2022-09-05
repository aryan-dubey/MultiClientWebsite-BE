package com.multiclientweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiclientweb.entity.ProductMgmt;
import com.multiclientweb.exceptions.ResourceNotFoundException;
import com.multiclientweb.repository.ProductMgmtRepository;
import java.util.*;



@Service
public class ProductMgmtServices {
	//String msgAD = "Access Denied";
	//String msgUNF = "User not found";
	
	@Autowired 
	ProductMgmtRepository productmgmtrepository;

	public boolean addProduct(ProductMgmt productmgmt, int vendorId) {
		ProductMgmt pm = productmgmtrepository.findByProductName(productmgmt.getProductName());

		//vendor ven = AppUserRepository.findById(vendorId).get();
		//if (ven == null) {
		//	throw new ResourceNotFoundException("User not found ");
		//} 
		//	else if (ven.gettype().equals("user")) {
		//	throw new NotAdminException("Access Denied");
		//}
		if (pm == null) {
			productmgmtrepository.save(productmgmt);
			return true;
		} else {
			System.out.println("Product already exist");
			return false;
		}
	}

	
	
	public void deleteProduct(int productId, int vendorId) {
		//vendorId ven = customerRepository.findById(vendorId).get();
		//if (ven == null) {
		//	throw new ResourceNotFoundException("User not found ");
		//} else if (ven.gettype().equals("user")) {
		//	throw new NotAdminException("Access Denied");
		//} else if (
				
//			if(productmgmtrepository.findById(vendorId).isPresent()) 
//			{
				productmgmtrepository.deleteById(vendorId);
//			}
	}
	
	public ProductMgmt updateProduct(ProductMgmt productmgmt, int vendorId) {
//		vendorId ven = customerRepository.findById(vendorId).get();
		ProductMgmt pm = productmgmtrepository.findById(productmgmt.getProductId()).get();
//		if (cust == null) {
//			throw new ResourceNotFoundException("User not found ");
//		} else if (cust.gettype().equals("user")) {
//			throw new NotAdminException("Access Denied");
//		} else 
		if (pm!=null) {
			pm.setProductCost(productmgmt.getProductCost());
			pm.setProductDescription(productmgmt.getProductDescription());
			pm.setProductName(productmgmt.getProductName());
			pm.setProductType(productmgmt.getProductType());
			productmgmtrepository.save(pm);
			System.out.println(pm.getProductName());
			return pm;
			
		}
		else {
			throw new ResourceNotFoundException("Product not found ");
		}
	}

	public List viewProductList() {
		return productmgmtrepository.findAll();
	}
	

}