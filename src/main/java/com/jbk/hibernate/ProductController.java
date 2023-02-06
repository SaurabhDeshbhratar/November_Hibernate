package com.jbk.hibernate;

import java.util.List;
import java.util.Scanner;

import com.jbk.hibernate.dao.ProductDao;
import com.jbk.hibernate.entity.Product;
import com.jbk.hibernate.service.ProductService;
import com.jbk.hibernate.utility.ProductUtility;

public class ProductController {

	public static void main(String[] args) {

		char ch;
		Scanner scanner = new Scanner(System.in);
		ProductService service = new ProductService();

		do {

			System.out.println("press 1 for save product");
			System.out.println("press 2 for get product by Id");
			System.out.println("press 3 for delete product by Id");
			System.out.println("press 4 for update product by Id");
			System.out.println("press 5 for get all products");//for Criteria and Restriction
			System.out.println("press 6 for get all products");//Restriction.like from users
			System.out.println("press 7 for get all products");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				Product product = ProductUtility.prepareProductData(scanner);
				boolean isAdded = service.saveProduct(product);
				if (isAdded) {
					System.out.println("Saved !!");
				} else {
					System.out.println("Product already exists with Id " + product.getProductId());
				}
				break;
			}
			case 2: {
				System.out.println("Enter product Id");
				long productId = scanner.nextLong();
				Product product = service.getProductById(productId);
				if (product != null) {
					System.out.println(product);
				} else {
					System.out.println("Product not exists !! ID=" + productId);
				}

				break;
			}

			case 3: {
				System.out.println("Enter product Id");
				long productId = scanner.nextLong();
				boolean isDeleted = service.deleteProductById(productId);
				if (isDeleted) {
					System.out.println("deleted");
				} else {
					System.out.println("Product not deleted !! ID=" + productId);
				}

				break;
			}

			case 4: {
				Product product = ProductUtility.prepareProductData(scanner);
				boolean isUpdated = service.updateProduct(product);
				if (isUpdated) {
					System.out.println("Updated");
				} else {
					System.out.println("Product not exists !! ID= " + product.getProductId());
				}
				break;
			}
			case 5:{
				List<Product> allProducts = service.getAllProducts();
				if (allProducts == null || allProducts.isEmpty()) {
					System.out.println("Product Not exists");
				} else {
					for (Product product : allProducts) {
						System.out.println(product);
					}
				}
				break;
			} 
			case 6: {
				System.out.println("type for search");
				String exp = scanner.next();
				List<Product> allProducts = service.getAllProducts(exp);
				if (allProducts == null || allProducts.isEmpty()) {
					System.out.println("Product Not exists");
				} else {
					for (Product product : allProducts) {
						System.out.println(product);
					}
				}
				break;
			} 
			
			
			
			default:
				break;
			}

			System.out.println("Do you want to continue y/n");
			ch = scanner.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');
		System.out.println("terminated");

	}
}
