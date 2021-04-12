package com.niit.OnlineFrontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.OnlineBackend.DAO.CategoryDAO;
import com.niit.OnlineBackend.DAO.ProductDAO;
import com.niit.OnlineBackend.model.Category;
import com.niit.OnlineBackend.model.Product;
import com.niit.OnlineFrontend.util.UplodeFile;
import com.niit.OnlineFrontend.validator.ProductValidate;

@Controller
@RequestMapping(value="/manage")
public class ManageProductController 
{
	private Product product;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/product")
	public ModelAndView manageProduct(@RequestParam(name="operation", required=false) String operation)
	{
		ModelAndView mv = new ModelAndView("page");
	
		mv.addObject("title","Manage Product");
		mv.addObject("userclickManageProduct",true);
		
		if(operation != null) 
		{
			if(operation.equals("product"))
			{
				mv.addObject("message", "Product submitted successfully!");
			}
			
			if(operation.equals("category"))
			{
				mv.addObject("message", "Category created successfully!");
			}
		}
		
		return mv;
	}
	
	@ModelAttribute("product") 
	public Product modelProduct() 
	{
		product = new Product();
		product.setSupplierId(2);
		product.setActive(true);
		
		return product;
	}
	
	@ModelAttribute("categories") 
	public List<Category> modelCategories() 
	{
		return categoryDAO.getActiveCategories();
	}
	
	@ModelAttribute("category") 
	public Category modelCategory() 
	{
		return (new Category());
	}
	
	@RequestMapping(value = "/add/product", method=RequestMethod.POST)
	public String handleProductSubmission( @Valid @ModelAttribute("product") Product newProduct, BindingResult results,Model model,HttpServletRequest request)
	{
		
			new ProductValidate().validate(newProduct,results);
			
			if(results.hasErrors()) 
			{
				
				model.addAttribute("userclickManageProduct",true);
				model.addAttribute("title","Product Management");
				//model.addAttribute("message", "Validation fails for adding the product!");
				return "page";
			}
			
			
			productDAO.addProduct(newProduct);
			
			if(!newProduct.getFile().getOriginalFilename().equals("") )
			{
				UplodeFile.uploadFile(request, newProduct.getFile(), newProduct.getCode()); 
			 }
			
		return "redirect:/manage/product?operation=product";
	}
	
	
	@RequestMapping(value = "/add/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute("category") Category newCategory)
	{
			categoryDAO.addCategory(newCategory);
			
		return "redirect:/manage/product?operation=category";
	}
}
