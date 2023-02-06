package com.jbk.hibernate.service;

import java.util.List;

import com.jbk.hibernate.dao.ProductDao;
import com.jbk.hibernate.entity.Product;

public class ProductService {

	ProductDao dao= new ProductDao();
	
	public boolean saveProduct(Product product) {
		return dao.saveProduct(product);
		
	}
	
	public Product getProductById(long productId) {
		return dao.getProductById(productId);
	}

	public boolean deleteProductById(long productId) {
	boolean isDeleted=dao.deleteProductById(productId);
		return isDeleted;
	}

	public boolean updateProduct(Product product) {
		boolean isUpdated=dao.updateProduct(product);
		return isUpdated;
	}
	
    
	public List<Product> getAllProducts(String exp) {
		return dao.getAllProducts(exp);
	}
	
	public List<Product> getAllProducts() {
		return dao.getAllProducts();
	}
	
}
