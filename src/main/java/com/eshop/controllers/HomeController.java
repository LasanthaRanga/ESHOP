package com.eshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/signup")
	public String goToSignUp(){
		return"SingUp";
	}
	
	@RequestMapping("/blank")
	public String goToblank(){
		return"admin/blank";
	}
	
	
	
}
