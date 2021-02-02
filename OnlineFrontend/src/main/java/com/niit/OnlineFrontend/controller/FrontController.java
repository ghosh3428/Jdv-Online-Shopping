package com.niit.OnlineFrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController 
{

	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		
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
	
	@RequestMapping(value="/services")
	public ModelAndView services()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userclickservices",true);
		mv.addObject("title" , "SERVICES");
		return mv;
	}
}
