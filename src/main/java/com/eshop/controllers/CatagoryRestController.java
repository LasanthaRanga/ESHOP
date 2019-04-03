package com.eshop.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.entitiy.Maincat;
import com.eshop.entitiy.Subcat1;
import com.eshop.entitiy.Subcat2;
import com.eshop.service.MaincatServiceImpl;
import com.eshop.service.Subcat1ServiceImpl;
import com.eshop.service.Subcat2ServiceImpl;

@RestController
public class CatagoryRestController {

	@Autowired
	MaincatServiceImpl maincatSI;
	
	@Autowired
	Subcat1ServiceImpl sub1SI;

	@RequestMapping("/maincat/{id}")
	public Maincat getSelectedMain(@PathVariable("id") Integer id) {
		Maincat mc = null;
		try {
			mc = maincatSI.getById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mc;
	}
	
	@RequestMapping("/subcat2/{id}")
	public Set<Subcat2> getSubCats2(@PathVariable("id") Integer id) {
		Set<Subcat2> subcat2s = null;
		try {
			 subcat2s = sub1SI.getById(id).getSubcat2s();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("OK OK");
		return subcat2s;
	}
	
	@RequestMapping("/subcat/{id}")
	public Set<Subcat1> getSubCats(@PathVariable("id") Integer id) {
		Set<Subcat1> subcat1s = null;
		try {
			 subcat1s = maincatSI.getById(id).getSubcat1s();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("OK OK");
		return subcat1s;
	}
	
	@RequestMapping("/maincat")
	public List<Maincat> getAllMain() {
		List<Maincat> mclist = null;
		try {
			 mclist = maincatSI.getAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mclist;
	}

}
