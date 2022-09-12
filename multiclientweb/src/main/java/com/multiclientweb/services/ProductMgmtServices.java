package com.multiclientweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiclientweb.entity.ProductMgmt;
import com.multiclientweb.exceptions.ResourceNotFoundException;
import com.multiclientweb.repository.ProductMgmtRepository;


@Service
public class ProductMgmtServices {
	
	@Autowired 
	ProductMgmtRepository productmgmtrepository;

	
	//Add Product Function
	public boolean addProduct(ProductMgmt productmgmt) {
		ProductMgmt pm = productmgmtrepository.findByProductName(productmgmt.getProductName());
		if (pm == null) {
			productmgmtrepository.save(productmgmt);
			return true;
		} else {
			System.out.println("Product already exist");
			return false;
		}
	}
	

	
	//Delete Product Function
	public void deleteProduct(int productId) {
				productmgmtrepository.deleteById(productId);
				}
	
	
	//Update Product Function
	public ProductMgmt updateProduct(ProductMgmt productmgmt, int productId) {
		ProductMgmt pm = productmgmtrepository.findByProductId(productId);
		if (pm!=null) {
			pm.setProductCost(productmgmt.getProductCost());
			pm.setProductDescription(productmgmt.getProductDescription());
			pm.setProductName(productmgmt.getProductName());
			pm.setProductCategory(productmgmt.getProductCategory());
			productmgmtrepository.save(pm);
			return pm;
			
		}
		else {
			throw new ResourceNotFoundException("Product not found ");
		}
	}
	
	//List All Products Function
	public List viewProductList() {
		return productmgmtrepository.findAll();
	}
	

}