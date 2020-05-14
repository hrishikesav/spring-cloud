package com.sapient.ecommerce.searchapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.ecommerce.searchapp.model.Product;
import com.sapient.ecommerce.searchapp.service.ProductService;
import com.sapient.ecommerce.searchapp.util.ProductFactory;
import com.sapient.ecommerce.searchapp.util.ProductSize;

@SpringBootTest
class EcomSearchAppApplicationTests {
	
	@Autowired
	ProductFactory productFactory;
	
	@Autowired
	ProductService productService;
	
	@Test
	public void doShirtCountValidation() {
		String brandToTest = "Peter England";
		Product productToTest = productFactory.getProduct("shirt");
		productToTest.setBrandName(brandToTest);
		
		Product product = productFactory.getProduct("shirt");
		product.setBrandName(brandToTest);
		product.setColor("Blue");
		product.setPrice(500.00);
		product.setProductSize(ProductSize.L);
		product.setProductType("shirt");
		
		
		List<Product> productByBrand = productService.getProductByBrand(productToTest);
		
		assertEquals(1, productByBrand.size());
		
	}
	
	@Test
	public void doShirtPriceCountValidation() {
		
	}
	
	@Test
	public void doShirtColorCountValidation() {
		
	}
	
	@Test
	public void doShirtSizeCountValidation() {
		
	}
	
	@Test
	public void doAvailableProductByBrandValidation() {
		
	}

	@Test
	void contextLoads() {
	}

}
