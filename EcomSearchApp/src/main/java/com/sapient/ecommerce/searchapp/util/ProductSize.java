package com.sapient.ecommerce.searchapp.util;


public enum ProductSize {
	
	S("Short"),
	M("Medium"),
	L("Large"),
	XL("XLarge");
	
	private String size;
	
	ProductSize(String size) {
		this.size = size;
	}
}
