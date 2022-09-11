package com.multiclientweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multiclientweb.entity.ProductMgmt;
import com.multiclientweb.services.ProductMgmtServices;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductMgmtController {
	@Autowired
	ProductMgmtServices productmgmtservices;
	@PostMapping("/api/auth/addproduct")
	public ResponseEntity addProduct(@RequestBody ProductMgmt productmgmt) 
	{		
        if( productmgmtservices.addProduct(productmgmt))
        {
            return ResponseEntity.status(HttpStatus.OK).body(productmgmt);

        }

        	return ResponseEntity.status(HttpStatus.FOUND).body("Product already exist");
		}
	
	
	
	
	@DeleteMapping("/api/auth/delproduct/{productId}")
	public ResponseEntity deleteProduct(@PathVariable int productId) 
	{
		productmgmtservices.deleteProduct(productId);
		return ResponseEntity.status(HttpStatus.OK).body("Product Deleted");
		
	}
	
	
	
	@PutMapping("/api/auth/updateproduct/{productId}")
	public ResponseEntity updateProduct(@RequestBody ProductMgmt productmgmt,@PathVariable int productId) 
	{		
        
        return ResponseEntity.status(HttpStatus.OK).body(productmgmtservices.updateProduct(productmgmt,productId));
	}
	
	
	
	
	
	@GetMapping("/api/auth/viewproduct")
	public List viewProduct()
	{
		return productmgmtservices.viewProductList(	);
		
	}

}