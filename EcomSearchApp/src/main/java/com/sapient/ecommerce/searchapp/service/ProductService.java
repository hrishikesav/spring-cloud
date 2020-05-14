package com.sapient.ecommerce.searchapp.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sapient.ecommerce.searchapp.model.Product;

@Component
public interface ProductService {
	
	void storeProduct(Product product);
	
	List<Product> getProductByBrand(Product product);
	
	List<Product> getProductByColor(Product product);
	
}
