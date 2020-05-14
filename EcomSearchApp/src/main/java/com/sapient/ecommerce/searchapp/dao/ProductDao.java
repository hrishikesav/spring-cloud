package com.sapient.ecommerce.searchapp.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sapient.ecommerce.searchapp.model.Product;

@Component
public interface ProductDao {
	
	void saveProduct(Product product);
	List<Product> getProductByBrand(Product product);
	List<Product> getProductByColor(Product product);
}
