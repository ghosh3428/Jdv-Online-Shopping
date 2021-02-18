package com.niit.OnlineFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.OnlineBackend.DAO.CategoryDAO;
import com.niit.OnlineBackend.DAO.ProductDAO;
import com.niit.OnlineBackend.model.Category;
import com.niit.OnlineBackend.model.Product;

@Controller
public class FrontController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("categorylist",categoryDAO.getActiveCategories());
		
		mv.addObject("userclickhome",true);
		mv.addObject("title" , "ONLINE SHOPPING");
		return mv;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userclickcontact",true);
		mv.addObject("title" , "CONTACT US");
		return mv;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userclickabout",true);
		mv.addObject("title" , "ABOUT US");
		return mv;
	}
	
	@RequestMapping(value="show/all/products")
	public ModelAndView viewAllProduct()
	{
		ModelAndView mv = new ModelAndView("page");
		
		
		mv.addObject("categorylist",categoryDAO.getActiveCategories());
		
		mv.addObject("userclickAllProducts",true);
		mv.addObject("title" , "All Product");
	
		return mv;
	}
	@RequestMapping(value="show/category/{id}/products")
	public ModelAndView viewCategoryProduct(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("page");
		
		
		mv.addObject("categorylist",categoryDAO.getActiveCategories());
		
		Category category = null;
		category = categoryDAO.getCategory(id);
		mv.addObject("category",category);
		
		mv.addObject("userclickCategoryProducts",true);
		mv.addObject("title" , "ONLINE SHOPPING");
	
		return mv;
	}
	
	@RequestMapping(value="show/{id}/product")
	public ModelAndView viewSingleProduct(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.getSingleProduct(id);
		
		
		mv.addObject("userclickSingleProduct",true);
		mv.addObject("product", product);
		mv.addObject("title",product.getName());
	
		return mv;
	}
	

	
	
}
