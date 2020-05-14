package com.sapient.ecommerce.searchapp.util;

import org.springframework.stereotype.Component;

import com.sapient.ecommerce.searchapp.model.PantProduct;
import com.sapient.ecommerce.searchapp.model.Product;
import com.sapient.ecommerce.searchapp.model.ShirtProduct;

@Component
public class ProductFactory {
	
	public Product getProduct(String productType) {
		if(productType.equalsIgnoreCase("shirt")) {
			return new ShirtProduct();
		} else if(productType.equalsIgnoreCase("pants")) {
			return new PantProduct();
		} else {
			return null;
		}
	}
}
