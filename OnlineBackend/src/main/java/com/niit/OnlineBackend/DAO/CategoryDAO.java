package com.niit.OnlineBackend.DAO;

import java.util.List;

import com.niit.OnlineBackend.model.Category;

public interface CategoryDAO 
{
	
	Category getCategory(int id);
	List<Category> categoryList();
	boolean insert(Category category);
	boolean update(Category category);
	boolean delete(Category category);
}
