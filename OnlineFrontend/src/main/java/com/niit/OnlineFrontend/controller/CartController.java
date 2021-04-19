package com.niit.OnlineFrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/cart")
public class CartController 
{
	@RequestMapping("/show")
	public ModelAndView showCart() {

		ModelAndView mv = new ModelAndView("page");

		
		mv.addObject("title", "Shopping Cart");
		mv.addObject("userclickShowCart", true);
		mv.addObject("cartLines", 2);

		return mv;

	}
}
