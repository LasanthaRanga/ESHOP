package com.eshop.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.entitiy.Product;
import com.eshop.entitiy.Shop;
import com.eshop.entitiy.Shophasproduct;
import com.eshop.entitiy.User;
import com.eshop.service.ProductServiceImpl;
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
	ProductServiceImpl psi;
	
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
	
	
	
	
	@RequestMapping("/productlist")
	public String productlist(HttpSession session,ModelMap mm) {
		
		User u = (User) session.getAttribute("user");
		Set<Shop> shops = u.getShops();

		Shop shop = null;
		if (shops != null && shops.size() > 0) {
			for (Shop s : shops) {
				shop = s;
				System.out.println(shop.getShopName());
			}
		}
		
		HashMap<Integer,Product> hashMap = new HashMap<>();
		
		if(shop!=null) {
			Set<Shophasproduct> shophasproducts = shop.getShophasproducts();
			for(Shophasproduct shp :shophasproducts) {
				hashMap.put(shp.getProductIdProduct(), psi.getById(shp.getProductIdProduct()));
			}
		}
		
		
		List<Product> all = psi.getAll();
		
		for(Product pro : all) {
			Product product = hashMap.get(pro.getIdProduct());
			if(product!=null) {
				pro.setProductStatus2(1);
				hashMap.replace(pro.getIdProduct(), pro);
			}else {
				pro.setProductStatus2(0);
				hashMap.put(pro.getIdProduct(), pro);
			}
			
		}
		
		mm.addAttribute("items", hashMap);
		return "admin/allproducts";
	}

	
	@RequestMapping(value = "/addtoshop/{uid}/{idpro}", method = RequestMethod.GET)
	public void addProToShop(@PathVariable Integer uid, @PathVariable int idpro) {
		
		System.out.println("MEkata awa                    000000000000000000000");
		
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
		shps.save(shp);
		
//		new ItemController().loadOneProduct(idpro, mm, session);
//		Product byId = psi.getById(idpro);
//		mm.addAttribute("item", byId);
//		session.setAttribute("hasitem", byId);
//		return "/product";
		
		
	}
	
	@RequestMapping("/allshops")
	public String allShops(ModelMap mm) {
		List<Shop> all = ssi.getAll();
		mm.addAttribute("shops", all);
		return"/allshops";
	}
	
	@RequestMapping("/itemsinshop/{id}")
	public String proinShop(ModelMap mm, @PathVariable("id") Integer id,HttpSession session) {
		Shop byId = ssi.getById(id);
		session.setAttribute("shopid", id);
		Set<Shophasproduct> shophasproducts = byId.getShophasproducts();
		List<Product> all = new ArrayList<>();
		for(Shophasproduct shp : shophasproducts ) {			;
			all.add(psi.getById(shp.getProductIdProduct()));
		}				
		mm.addAttribute("items", all);
		return "/proinshop";
	}
	
	
	
	
	

}
