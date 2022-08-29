package com.multiclientweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multiclientweb.entity.ProductMgmt;
import com.multiclientweb.services.ProductMgmtServices;

@RestController
public class ProductMgmtController {
	@Autowired
	ProductMgmtServices ProductMgmtservices;
	public ResponseEntity addProduct(@RequestBody ProductMgmt productmgmt,@PathVariable int vendorId) 
	{		
        if( ProductMgmtservices.add(productmgmt,vendorId))
        {
            return ResponseEntity.status(HttpStatus.OK).body(productmgmt);

        }

        	return ResponseEntity.status(HttpStatus.FOUND).body("Product already exist");
		}
	

}