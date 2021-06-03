package com.niit.OnlineBackend.DAO;

import java.util.List;


import com.niit.OnlineBackend.model.Address;
import com.niit.OnlineBackend.model.Cart;
import com.niit.OnlineBackend.model.User;

public interface UserDAO 
{
boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	boolean updateCart(Cart cart);
	
	User getByEmail(String email) ;
	
	Address getBillingAddress(int userId);
	
	List<Address> listShippingAddresses(int userId);
	
	Address getAddress(int addressId);
}
