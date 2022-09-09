package com.multiclientweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class ProductOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	@Column(name = "amount",nullable = false)
	private double amount;
	@Column(name = "bill_date")
	private String billDate;
	@Column
    @NotBlank(message = "paymentmethod is required")
	private String paymentMethod;
}
