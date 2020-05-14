package com.sapient.ecommerce.searchapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.ecommerce.searchapp.model.Product;
import com.sapient.ecommerce.searchapp.service.ProductService;
import com.sapient.ecommerce.searchapp.util.ProductFactory;
import com.sapient.ecommerce.searchapp.util.ProductServiceFactory;

@RestController
public class ProductSearchController {
	
	@Autowired
	ProductServiceFactory productServiceFactory;
	
	@Autowired
	ProductFactory productFactory;
	
	
	@PostMapping("/product")
	public void storeProductInfo(@RequestParam Product product) {
		ProductService productService = productServiceFactory.getProductService(product);
		productService.storeProduct(product);
	}
	
	@GetMapping("/productBrands/{brand}")
	public String getProductByBrand(@PathParam(value = "brand") String brand) {
		Product product = productFactory.getProduct("shirt");
		product.setBrandName(brand);
		ProductService productService = productServiceFactory.getProductService(product);
		List<Product> productByBrand = productService.getProductByBrand(product);
		
		List<String> resultProducts = productByBrand.stream().map(e -> e.getBrandName()).collect(Collectors.toList());
		return resultProducts.toString();
	}
	
	@GetMapping("/productColors/{color}")
	public String getProductByColor(@PathParam(value = "color") String color) {
		Product product = productFactory.getProduct("shirt");
		product.setBrandName(color);
		ProductService productService = productServiceFactory.getProductService(product);
		List<Product> productByBrand = productService.getProductByBrand(product);
		
		List<String> resultProducts = productByBrand.stream().map(e -> e.getBrandName()).collect(Collectors.toList());
		return resultProducts.toString();
	}
	
	// /product/{sku} - to get a product by its SKU
	// /productsSizes/{size} - to get all products with the specified size info
	// /productsPrices/{price} - to get all products matching a price
	// /products/shirts/{price} - to get all shirts matching a price
	// /products/pants/{price} - to get all pants matching a price
	
	
}
