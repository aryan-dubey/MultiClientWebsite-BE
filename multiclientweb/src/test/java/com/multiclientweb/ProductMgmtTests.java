package com.multiclientweb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiclientweb.entity.ProductMgmt;
import com.multiclientweb.repository.ProductMgmtRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ProductMgmtTests {

	@Autowired
	ProductMgmtRepository pmRepo;
	
	@Test
	@Order(1)
	void testAdd() {
		ProductMgmt pm = new ProductMgmt();
		pm.setProductName("Sony");
		pm.setProductCategory("Electronics");
		pm.setProductCost(500);
		pm.setProductDescription("Headphones");
		pmRepo.save(pm);
		assertNotNull(pmRepo.findByProductName("Sony").getProductName());
	}
	
	@Test
	@Order(2)
	void testRead() {
		List<ProductMgmt> list = pmRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
		
	}
	
	@Test
	@Order(3)
	void testUpdateNotEqual() {
	ProductMgmt pm = pmRepo.findByProductName("Sony");
	pm.setProductCost(1000);
	pmRepo.save(pm);
	assertNotEquals(1000, pmRepo.findByProductName("Sony").getProductCost());
	}
	
	@Test
	@Order(4)
	void testUpdateEquals() {
	ProductMgmt pm = pmRepo.findByProductName("Sony");
	pm.setProductCost(500);
	pmRepo.save(pm);
	assertEquals(500, pmRepo.findByProductName("Sony").getProductCost());
	}
	
	@Test
	@Order(5)
	void testDelete() {
		int pid = pmRepo.findByProductName("Sony").getProductId();
		pmRepo.deleteById(pid);
		assertThat(pmRepo.existsById(pid)).isFalse();
	}
}
