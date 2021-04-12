package com.niit.OnlineFrontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.OnlineBackend.model.Cart;
import com.niit.OnlineBackend.DAO.UserDAO;
import com.niit.OnlineBackend.model.Address;
import com.niit.OnlineBackend.model.User;
import com.niit.OnlineFrontend.model.RegisterModel;

@Component("registerHandler")
public class RegisterHandler 
{
	
	@Autowired
	private UserDAO userDAO;

	public RegisterModel init() 
	{
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel registerModel) 
	{
		String transitionValue = "success";
		User user = registerModel.getUser();
		if (user.getRole().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		
		// save the user
		userDAO.addUser(user);
		// save the billing address
		Address billing = registerModel.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		userDAO.addAddress(billing);
		return (transitionValue);
	}
	
	public String validate(User user , MessageContext error)
	{
		String transitionValue = "success";
		
		if(!(user.getPassword().equals(user.getConfirmPassword())))
		{
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Password does not match confirm password!")
					.build());
			
			 transitionValue = "failure"; 
			
		}
		
		if((userDAO.getByEmail(user.getEmail()) != null) ) 
		{
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("Email address is already taken!")
					.build());
			
			transitionValue = "failure";
		}
		
		
		
		return transitionValue;
	}
}
