package com.jbk.hibernate.utility;

import java.util.Scanner;

import com.jbk.hibernate.entity.Product;

public class ProductUtility {

	public static Product prepareProductData(Scanner scanner) {
		System.out.println("Enter ProductId");
		long productId= scanner.nextLong();
		
		System.out.println("Enter ProductName");
		String productName=scanner.next();
		
		System.out.println("Enter Category Id");
		long categoryID= scanner.nextLong();
		
		System.out.println("Enter Supplier Id");
		long supplierId=scanner.nextLong();
		
		System.out.println("Enter Product QTY");
		int productQTY=scanner.nextInt();
			
		System.out.println("Enter Product Price");
		double productPrice=scanner.nextDouble();
		
		Product product = new Product(productId, productName, supplierId, categoryID, productQTY, productPrice);
		
		
		
		return product;
		
		
	}
}
