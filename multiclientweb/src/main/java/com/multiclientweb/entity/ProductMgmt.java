package com.multiclientweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class ProductMgmt 
{
	@Id
	@SequenceGenerator(
	           name ="productmgmt_sequence",
	           sequenceName = "productmgmt_sequence",
	           allocationSize = 1
	   )
	@GeneratedValue(
	           strategy = GenerationType.SEQUENCE,
	           generator = "productmgmt_sequence"
	   )
	private int productId;
	private String productName;
	private String productCategory;
	private String productDescription;
	private double productCost;
	
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductCost() {
		return productCost;
	}
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	public ProductMgmt(int productId) {
		super();
		this.productId = productId;
	}
	
	
	
//	public ProductMgmt(int productId, String productName, String productCategory, String productDescription,
//			double productCost) {
//		super();
//		this.productId = productId;
//		this.productName = productName;
//		this.productCategory = productCategory;
//		this.productDescription = productDescription;
//		this.productCost = productCost;
//	}
	
	
	
	public ProductMgmt(String productName, String productCategory, String productDescription, double productCost) {
		super();
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productCost = productCost;
	}
	
	
	
	public ProductMgmt() {
		super();
	}
	
	
	
	
}
