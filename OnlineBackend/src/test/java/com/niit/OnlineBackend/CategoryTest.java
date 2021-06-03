package com.niit.OnlineBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OnlineBackend.DAO.CategoryDAO;
import com.niit.OnlineBackend.DAO.UserDAO;
import com.niit.OnlineBackend.model.Category;
import com.niit.OnlineBackend.model.User;

public class CategoryTest 
{


	private static AnnotationConfigApplicationContext context;

	static private CategoryDAO categoryDAO;
	static private Category category;
	

	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.OnlineBackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}

	 @Test
	public void testAddCategory() 
	{
		category = new Category();
		category.setName("Music Player");
		category.setDesc("Sample category for Music Player");
		category.setActive(true);
		category.setImageurl("cat5.jpg");
		
		assertEquals("Error adding user",true,categoryDAO.insert(category));
		
		
	}
	/*
	
	@Test
	public void testCategoryList() 
	{
		assertEquals("Error adding user",4,categoryDAO.getActiveCategories().size());
		
		
	}
	
	
	
	@Test
	public void testGetCategory() 
	{
		assertEquals("Error adding user","Laptop",categoryDAO.getCategory(3).getName());
		
		
	}
	
	
	@Test
	public void testUpdateCategory()
	{
		category = categoryDAO.getCategory(3);
		category.setName("Computer");
		assertEquals("Error adding user",true,categoryDAO.updateCategory(category));
		
	}
	
	@Test
	public void testDeleteCategory()
	{
		category = categoryDAO.getCategory(3);
		assertEquals("Error adding user",true,categoryDAO.deleteCategory(category));
		
	}
	*/
	
}
