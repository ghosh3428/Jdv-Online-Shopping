package com.niit.OnlineFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.OnlineBackend.DAO.ProductDAO;
import com.niit.OnlineBackend.model.Product;

@Controller
@RequestMapping(value="/json/show")
public class JsonController 
{
	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value="/all/products")
	@ResponseBody
	public List<Product> getAllAvtiveProduct()
	{
		return productDAO.getActiveProduct();
	}
	
	
	@RequestMapping(value="/category/{id}/products")
	@ResponseBody
	public List<Product> getActiveCategoryProduct(@PathVariable int id )
	{
		return productDAO.getCategoryProduct(id);
	}
}
