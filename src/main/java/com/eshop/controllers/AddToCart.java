package com.eshop.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eshop.entitiy.User;
import com.eshop.service.UserServiceImpl;

@Controller
public class AddToCart {

	@Autowired
	UserServiceImpl user;

	@RequestMapping("/addtocart")
	public String addToCart(@RequestParam("pid") String pid, @RequestParam("qty") Integer qty,
			HttpServletRequest request, ModelMap mm) {

		User user = (User) request.getSession().getAttribute("user");
		int shopid = Integer.parseInt(request.getSession().getAttribute("shopid").toString());
		if (user == null) {
			request.getSession().setAttribute("pid", pid);
			return "login";
		} else {
			
			
			
			
			System.out.println("=============================================================================");

			System.out.println(pid);
			System.out.println(qty);
			System.out.println("=============================================================================");

			return "";
		}

		// asdf

	}

}
