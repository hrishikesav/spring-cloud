package com.sapient.ecommerce.searchapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.ecommerce.searchapp.dao.ProductDao;
import com.sapient.ecommerce.searchapp.model.Product;
import com.sapient.ecommerce.searchapp.service.ProductService;

@Component
public class ShirtProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Product> getProductByBrand(Product product) {
		return productDao.getProductByBrand(product);
	}

	@Override
	public List<Product> getProductByColor(Product product) {
		return productDao.getProductByColor(product);
	}

	@Override
	public void storeProduct(Product product) {
		productDao.saveProduct(product);
	}

}
