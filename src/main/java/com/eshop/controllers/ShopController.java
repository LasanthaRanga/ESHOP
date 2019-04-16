package com.eshop.controllers;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.entitiy.Shop;
import com.eshop.entitiy.Shophasproduct;
import com.eshop.entitiy.User;
import com.eshop.service.ShopHasProductService;
import com.eshop.service.ShopServiceImpl;
import com.eshop.service.UserServiceImpl;

@Controller
public class ShopController {

	@Autowired
	ShopServiceImpl ssi;

	@Autowired
	ShopHasProductService shps;
	
	@Autowired 
	UserServiceImpl users;

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

	
	@RequestMapping(value = "/addtoshop/{uid}/{idpro}", method = RequestMethod.POST)
	public String addProToShop(@PathVariable Integer uid, @PathVariable int idpro) {
		
		User u = users.getById(uid);
		Set<Shop> shops = u.getShops();
		Shop shop = null;
		for (Shop s : shops) {
			shop = s;
		}

		Shophasproduct shp = new Shophasproduct();
		Date today = new Date();
		shp.setShop(shop);
		shp.setAddDate(today);
		shp.setProductIdProduct(idpro);
		shp.setShopHasProductStatus(1);
		Shophasproduct save = shps.save(shp);
		if (save != null) {
			return "done";
		} else {
			return "aul";
		}
		
	}

}
