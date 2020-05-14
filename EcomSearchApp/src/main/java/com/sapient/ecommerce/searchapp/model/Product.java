package com.sapient.ecommerce.searchapp.model;

import org.springframework.stereotype.Component;

import com.sapient.ecommerce.searchapp.util.ProductSize;

@Component
public class Product {
	
	String brandName;
	double price;
	String color;
	ProductSize productSize;
	String productType;
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public ProductSize getProductSize() {
		return productSize;
	}
	public void setProductSize(ProductSize productSize) {
		this.productSize = productSize;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	@Override
	public String toString() {
		return "Product [brandName=" + brandName + ", price=" + price + ", color=" + color + ", productSize="
				+ productSize + ", productType=" + productType + "]";
	}
	
}
