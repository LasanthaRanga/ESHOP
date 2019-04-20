package com.eshop.controllers;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;






import com.eshop.ajax.KeyVal;
import com.eshop.ajax.Response;
import com.eshop.entitiy.Shop;
import com.eshop.entitiy.Shophasproduct;
import com.eshop.entitiy.User;
import com.eshop.service.ProductServiceImpl;
import com.eshop.service.ShopHasProductService;
import com.eshop.service.ShopServiceImpl;
import com.eshop.service.UserServiceImpl;
import com.fasterxml.jackson.annotation.JacksonAnnotation;

@RestController
public class ShopRestController {
	
	@Autowired
	ShopServiceImpl ssi;

	@Autowired
	ShopHasProductService shps;
	
	@Autowired
	ProductServiceImpl psi;
	
	@Autowired 
	UserServiceImpl users;

	
	@PostMapping(value = "/addtoshopAjax")	
	public Response addProToShop(@RequestBody KeyVal kv) {
		
		System.out.println("MEkata awa                    000000000000000000000");
		
		int uid = Integer.parseInt(kv.getKey());
		int idpro = Integer.parseInt(kv.getVal());
		
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
		
		Response response = new Response();
		response.setStatus("Done");
		response.setData(shps);
		return response;
		
	}
	
	
	
}
