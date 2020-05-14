package com.sapient.ecommerce.searchapp.util;

import org.springframework.stereotype.Component;

import com.sapient.ecommerce.searchapp.model.Product;
import com.sapient.ecommerce.searchapp.service.ProductService;
import com.sapient.ecommerce.searchapp.service.impl.PantsProductServiceImpl;
import com.sapient.ecommerce.searchapp.service.impl.ShirtProductServiceImpl;

@Component
public class ProductServiceFactory {
	
	public ProductService getProductService(Product product) {
		if(product.getProductType().equalsIgnoreCase("shirt")) {
			return new ShirtProductServiceImpl();
		} else if(product.getProductType().equalsIgnoreCase("pants")) {
			return new PantsProductServiceImpl();
		} else {
			return null;
		}
	}

}
