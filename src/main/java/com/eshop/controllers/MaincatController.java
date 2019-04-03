package com.eshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.entitiy.Maincat;
import com.eshop.entitiy.Subcat1;
import com.eshop.entitiy.Subcat2;
import com.eshop.service.MaincatServiceImpl;
import com.eshop.service.Subcat1ServiceImpl;
import com.eshop.service.Subcat2ServiceImpl;

@Controller
public class MaincatController {


	@Autowired(required=true)
	MaincatServiceImpl mainCatServiceImpl;
	
	@Autowired
	Subcat1ServiceImpl subcat1ServiceImpl;
	
	@Autowired
	Subcat2ServiceImpl subcat2ServiceImpl;
	
	@RequestMapping("/admin")
	public String goToAdmin(ModelMap mm){
//		List<Maincat> all = mainCatServiceImpl.getAll();
//		mm.addAttribute("allmcat", all);
		return "/admin/dashboard";		
	}
	

	@RequestMapping("/maincatpage")
	public String goMaincat(ModelMap mm){
		List<Maincat> all = mainCatServiceImpl.getAll();
		mm.addAttribute("allmcat", all);
		return "/admin/maincat";		
	}
	
	

	@RequestMapping("/saveMaincat")
	public String saveMainController(@ModelAttribute("maincat") Maincat mc, ModelMap mm) {
		mc.setMaincatStatus(1);
		mainCatServiceImpl.save(mc);
		
		List<Maincat> all = mainCatServiceImpl.getAll();
		mm.addAttribute("allmcat", all);
		
		return "/admin/maincat";
	}
	
	
	@RequestMapping("/subcat")
	public String goToSubcat(ModelMap mm){
		List<Maincat> all = mainCatServiceImpl.getAll();
		mm.addAttribute("allmcat", all);
		List<Subcat1> alls = subcat1ServiceImpl.getAll();		
		mm.addAttribute("allscat1",alls);	
		return "/admin/subcatone";		
	}
	
	@RequestMapping("/saveSubcatOne")
	public String saveSubcatOne(@ModelAttribute("subcatone") Subcat1 sc1, ModelMap mm) {
		sc1.setSubcat1status(1);
		subcat1ServiceImpl.save(sc1);	
		List<Subcat1> all = subcat1ServiceImpl.getAll();		
		mm.addAttribute("allscat1",all);	
		List<Maincat> allm = mainCatServiceImpl.getAll();
		mm.addAttribute("allmcat", allm);	
		return "/admin/subcatone";
	}
	
	@RequestMapping("/subcat2")
	public String goToSubcat2(ModelMap mm){
		List<Subcat1> all = subcat1ServiceImpl.getAll();
		mm.addAttribute("allscat1", all);
		List<Subcat2> all2 = subcat2ServiceImpl.getAll();	
		mm.addAttribute("allscat2",all2);	
		return "/admin/subcattwo";		
	}
	
	@RequestMapping("/saveSubcatTwo")
	public String saveSubcatTwo(@ModelAttribute("subcattwo") Subcat2 sc2, ModelMap mm) {
		List<Subcat1> all = subcat1ServiceImpl.getAll();
		mm.addAttribute("allscat1", all);
		sc2.setSubcat2status(1);
		subcat2ServiceImpl.save(sc2);	
		List<Subcat2> all2 = subcat2ServiceImpl.getAll();	
		mm.addAttribute("allscat2",all2);	
		return "/admin/subcattwo";
	}
	
	
	
}
