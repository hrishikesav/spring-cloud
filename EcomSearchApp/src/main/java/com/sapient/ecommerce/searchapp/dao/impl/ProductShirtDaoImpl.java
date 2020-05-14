package com.sapient.ecommerce.searchapp.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.stream.Collectors;

import com.sapient.ecommerce.searchapp.dao.ProductDao;
import com.sapient.ecommerce.searchapp.model.Product;

public class ProductShirtDaoImpl implements ProductDao {
	
	List<Product> productShirtList = new ArrayList<Product>();
	
	private static Object lock = new Object();
	private static ReadWriteLock rwLock = new ReadWriteLock() {
		
		@Override
		public Lock writeLock() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Lock readLock() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	@Override
	public void saveProduct(Product product) {
		synchronized (lock) {
			productShirtList.add(product);
		}
	}

	@Override
	public List<Product> getProductByBrand(Product product) {
		String brand = product.getBrandName();
		
		rwLock.readLock().lock();
		
		List<Product> resultProductList = productShirtList.stream()
				.filter(e -> e.getBrandName().equals(brand))
				.collect(Collectors.toList());
		
		rwLock.readLock().unlock();
		
		return resultProductList;
	}

	@Override
	public List<Product> getProductByColor(Product product) {
		String color = product.getColor();
		
		rwLock.readLock().lock();
		
		List<Product> resultProductList = productShirtList.stream()
				.filter(e -> e.getColor().equals(color))
				.collect(Collectors.toList());
		
		rwLock.readLock().unlock();
		
		return resultProductList;
	}

}
