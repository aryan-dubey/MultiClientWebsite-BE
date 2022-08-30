package com.multiclientweb.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Orders {
	
	@Id//@Id annotation specifies the primary key of an entity
	//The @GeneratedValue annotation is to configure the way of increment of the specified column(field).
	
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderId;
	
	@Column 
	private double amount;
	
	@Column
	private LocalDate billDate;
	
	
//	@Column
//	@NotBlank(message="PaymentMethod is required")
	@Column
	private String paymentMethod;
	
	@OneToOne
	private Payment payment;
	
	@OneToOne
	private Cart cart;

    @ManyToOne
    
	private Customer customer;
	
	
	public Orders() {
		
	}


	
	public Orders(long l, double string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}











	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public LocalDate getBillDate() {
		return billDate;
	}


	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}



	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", amount=" + amount + ", billDate=" + billDate + ", paymentMethod="
				+ paymentMethod + ", payment=" + payment + ", cart=" + cart + ", customer=" + customer + "]";
	}
    
	
	
	                                                                    
}

