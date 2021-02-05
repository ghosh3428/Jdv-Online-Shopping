package com.niit.OnlineBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OnlineBackend.DAO.UserDAO;
import com.niit.OnlineBackend.model.User;

public class UserTest 
{
	private static AnnotationConfigApplicationContext context;
	private User user;
	static private UserDAO userDAO;
	

	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.OnlineBackend");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
	}

	@Test
	public void testAddUser() 
	{
		user = new User();
		user.setFirstName("Punkaj");
		user.setLastName("Singh");
		user.setEmail("ps@gmail.com");
		user.setContactNumber("1234567890");
		user.setRole("SUPPLIER");
		user.setPassword("pass");
		user.setEnabled(true);
		
		assertEquals("Error adding user",true,userDAO.addUser(user));
		
		
	}
}
