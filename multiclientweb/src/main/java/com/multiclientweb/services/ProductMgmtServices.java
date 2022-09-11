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

	public boolean addProduct(ProductMgmt productmgmt) {
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

	
	
	public void deleteProduct(int productId) {
		//vendorId ven = customerRepository.findById(vendorId).get();
		//if (ven == null) {
		//	throw new ResourceNotFoundException("User not found ");
		//} else if (ven.gettype().equals("user")) {
		//	throw new NotAdminException("Access Denied");
		//} else if (
				
//			if(productmgmtrepository.findById(vendorId).isPresent()) 
//			{
				productmgmtrepository.deleteById(productId);
//			}
	}
	
	public ProductMgmt updateProduct(ProductMgmt productmgmt, int productId) {
//		vendorId ven = customerRepository.findById(vendorId).get();
		ProductMgmt pm = productmgmtrepository.findByProductId(productId);
//		if (cust == null) {
//			throw new ResourceNotFoundException("User not found ");
//		} else if (cust.gettype().equals("user")) {
//			throw new NotAdminException("Access Denied");
//		} else 
		if (pm!=null) {
			pm.setProductCost(productmgmt.getProductCost());
			pm.setProductDescription(productmgmt.getProductDescription());
			pm.setProductName(productmgmt.getProductName());
			pm.setProductCategory(productmgmt.getProductCategory());
			productmgmtrepository.save(pm);
			//System.out.println(pm.getProductName());
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