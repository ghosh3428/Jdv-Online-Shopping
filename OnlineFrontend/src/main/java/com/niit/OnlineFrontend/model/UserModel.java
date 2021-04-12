package com.niit.OnlineFrontend.model;

import com.niit.OnlineBackend.model.Cart;

public class UserModel 
{
private static final long serialVersionUID = 1L;
	
	private int id;
	private String fullName;
	private String role;
	private Cart cart;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
