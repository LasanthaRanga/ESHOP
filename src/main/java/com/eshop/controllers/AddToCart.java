package com.eshop.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eshop.entitiy.Cart;
import com.eshop.entitiy.Carthasproduct;
import com.eshop.entitiy.Price;
import com.eshop.entitiy.Product;
import com.eshop.entitiy.Shop;
import com.eshop.entitiy.Shophasproduct;
import com.eshop.entitiy.User;
import com.eshop.service.CartHasProductImpl;
import com.eshop.service.CartServiceImpl;
import com.eshop.service.ProductServiceImpl;
import com.eshop.service.ShopServiceImpl;
import com.eshop.service.UserServiceImpl;

@Controller
public class AddToCart {

	@Autowired
	UserServiceImpl user;

	@Autowired
	CartServiceImpl csi;

	@Autowired
	CartHasProductImpl chpi;

	@Autowired
	ShopServiceImpl ssi;

	@Autowired
	ProductServiceImpl proi;

	@RequestMapping("/addtocart")
	public String addToCart(@RequestParam("pid") String pid, @RequestParam("qty") Integer qty,
			HttpServletRequest request, ModelMap mm) {
		int shopid = Integer.parseInt(request.getSession().getAttribute("shopid").toString());
		User user = (User) request.getSession().getAttribute("user");

		Cart cc = null;

		Set<Cart> carts = user.getCarts();
		if (carts != null && carts.size() > 0) {
			try {
				
			
			for (Cart c : carts) {
				if (c.getCartStatus() == 1.0) {
					cc = c;
				}
			}
			if (cc.getShop().getIdShop() == shopid) {

				Double cartTotal = cc.getCartTotal();

				Product product = proi.getById(Integer.parseInt(pid));

				double selprice = 0;

				Set<Price> prices = product.getPrices();
				for (Price pr : prices) {
					selprice = pr.getSelling();
				}

				double pp = selprice * qty;
				cartTotal += pp;
				cc.setCartTotal(cartTotal);				
				Cart update = csi.update(cc);

				Carthasproduct chp = new Carthasproduct();
				chp.setCart(update);
				chp.setProduct(product);
				chp.setCartHasProductQty(qty);
				chp.setCartHasProductStatus(1);
				chpi.save(chp);

				Set<Shophasproduct> shophasproducts = cc.getShop().getShophasproducts();
				List<Product> all = new ArrayList<>();
				for (Shophasproduct shp : shophasproducts) {
					;
					all.add(proi.getById(shp.getProductIdProduct()));
				}
				mm.addAttribute("items", all);
				return "/proinshop";

			} else {
				// message shop is not same remove item ore finsish cart message;
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Shop shop = ssi.getById(shopid);

			if (user == null) {
				// request.getSession().setAttribute("pid", pid);
				return "login";
			} else {

				Product product = proi.getById(Integer.parseInt(pid));

				double selprice = 0;

				Set<Price> prices = product.getPrices();
				for (Price pr : prices) {
					selprice = pr.getSelling();
				}

				double pp = selprice * qty;

				Cart cart = new Cart();
				cart.setShop(shop);
				cart.setUser(user);
				cart.setCartTotal(pp);
				cart.setCartStatus(1.0);

				Cart savedCart = csi.save(cart);

				Carthasproduct chp = new Carthasproduct();
				chp.setCart(savedCart);
				chp.setProduct(product);
				chp.setCartHasProductQty(qty);
				chp.setCartHasProductStatus(1);
				chpi.save(chp);

				Set<Shophasproduct> shophasproducts = shop.getShophasproducts();
				List<Product> all = new ArrayList<>();
				for (Shophasproduct shp : shophasproducts) {
					;
					all.add(proi.getById(shp.getProductIdProduct()));
				}
				mm.addAttribute("items", all);
				return "/proinshop";

			}
			
		}
		return "";

	}
	
	@RequestMapping("/cart")
	public String goToCart(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {			
			return "login";
		} else {
			return "/cart";
		}		
	}
	
	

}
