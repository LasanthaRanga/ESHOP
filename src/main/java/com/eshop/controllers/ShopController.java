package com.eshop.controllers;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.entitiy.Shop;
import com.eshop.entitiy.User;
import com.eshop.service.ShopServiceImpl;

@Controller
public class ShopController {

	@Autowired
	ShopServiceImpl ssi;

	@RequestMapping("/myshop")
	public String myshop(HttpSession session, ModelMap modleMap) {
		User u = (User) session.getAttribute("user");
		Set<Shop> shops = u.getShops();

		Shop shop = null;
		if (shops != null && shops.size() > 0) {
			for (Shop s : shops) {
				shop = s;
				System.out.println(shop.getShopName());
			}
		}

		modleMap.addAttribute("shop", shop);
		return "/admin/createshop";
	}

	@RequestMapping("/createshop")
	public String createShop(HttpSession session, ModelMap modelmap, @ModelAttribute("shop") Shop shop) {
		User u = (User) session.getAttribute("user");

		Set<Shop> shops = u.getShops();
		if (shops != null && shops.size() > 0) {			
		} else {
			Date today = new Date();
			shop.setUser(u);
			shop.setShopStartDate(today);
			shop.setShopStatus(1);
			ssi.save(shop);
			modelmap.addAttribute("shop", "Elakir Kollek");
		}
		return "/admin/createshop";
	}
	
	
	

}
