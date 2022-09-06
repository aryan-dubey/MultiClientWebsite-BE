package com.multiclientweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiclientweb.entity.ProductOrder;
import com.multiclientweb.services.ProductOrderServices;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2/")
public class ProductOrderController {

	private ProductOrderServices productOrderServices;

	public ProductOrderController(ProductOrderServices productOrderServices) {
		super();
		this.productOrderServices = productOrderServices;
	}
	
	// build create employee REST API
		@PostMapping("/orders")
		public ResponseEntity<ProductOrder> createOrder(@Valid @RequestBody ProductOrder productOrder){
			return new ResponseEntity<ProductOrder>(productOrderServices.saveOrder(productOrder), HttpStatus.CREATED);
		}
		
		// build get all employees REST API
		@GetMapping("/orders")
		public List<ProductOrder> getAllOrders(){
			return productOrderServices.getAllOrders();
		}
		
		// build get employee by id REST API
		// http://localhost:8080/api/employees/1
		@GetMapping("/orders/{id}")
		public ResponseEntity<ProductOrder> getOrderById(@PathVariable("id") long orderId){
			return new ResponseEntity<ProductOrder>(productOrderServices.getOrderById(orderId), HttpStatus.OK);
		}
		
		
		// build update employee REST API
		// http://localhost:8080/api/employees/1
		@PutMapping("/orders/{id}")
		public ResponseEntity<ProductOrder> updateOrder(@PathVariable("id") long id
													  ,@RequestBody ProductOrder productOrder){
			return new ResponseEntity<ProductOrder>(productOrderServices.updateOrder(productOrder, id), HttpStatus.OK);
		}
		

		// build delete employee REST API
		// http://localhost:8080/api/employees/1
		@DeleteMapping("/orders/{id}")
		public ResponseEntity<String> deleteOrder(@PathVariable Long id){
			
			// delete employee from DB
		    productOrderServices.deleteOrder(id);
			
			return new ResponseEntity<String>("Order deleted successfully!.", HttpStatus.OK);
		}
}
