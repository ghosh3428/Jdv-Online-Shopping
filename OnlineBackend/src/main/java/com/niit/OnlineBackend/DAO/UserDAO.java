package com.niit.OnlineBackend.DAO;

import com.niit.OnlineBackend.model.Address;
import com.niit.OnlineBackend.model.User;

public interface UserDAO 
{
	public boolean addUser(User user);
	
	public boolean addAddress(Address address);
	
	public User getByEmail(String email);
}
