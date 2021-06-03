package com.niit.OnlineBackend.DAO;

import java.util.List;

import com.niit.OnlineBackend.model.Product;

public interface ProductDAO 
{

	Product getProduct(int productId);
	List<Product> productList();	
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
	
	List<Product> listActiveProducts();	
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	List<Product> getProductsByParam(String string, int i);
	
}
