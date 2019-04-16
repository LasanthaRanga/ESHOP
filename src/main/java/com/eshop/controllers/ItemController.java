package com.eshop.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eshop.entitiy.Image;
import com.eshop.entitiy.Maincat;
import com.eshop.entitiy.Price;
import com.eshop.entitiy.Product;
import com.eshop.service.ImageServiceImpl;
import com.eshop.service.PriceServiceImpl;
import com.eshop.service.ProductServiceImpl;

@Controller
public class ItemController {

	// Save the uploaded file to this folder
	private static String UPLOADED_FOLDER = "uploads\\";

	@Autowired
	ProductServiceImpl psi;

	@Autowired
	PriceServiceImpl priceImpl;

	@Autowired
	ImageServiceImpl ImageImpl;

	@RequestMapping("saveitem")
	public String goToItemSave() {
		return "/admin/saveitem";
	}

	@RequestMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product pro, ModelMap mm) {
		Product save = psi.save(pro);
		mm.addAttribute("item", save);
		return "/admin/uploads";
	}

	@RequestMapping("/additem")
	public String saveProductAndPrice(@ModelAttribute("product") Product pro, @ModelAttribute("price") Price price,
			ModelMap mm) {
		Product save = psi.save(pro);
		mm.addAttribute("item", save);
		price.setProduct(save);
		price.setPriceStatus(1);
		priceImpl.save(price);
		return "/admin/uploads";
	}

	@RequestMapping("/uploads")
	public String uploads() {
		return "/admin/uploads";
	}

	@PostMapping("/upload") // //new annotation since 4.3
	public String singleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("pid") String pid,
			HttpServletRequest request, ModelMap mm) {

		String realPath = request.getServletContext().getRealPath("/");

		if (file.isEmpty()) {
			// redirectAttributes.addFlashAttribute("message", "Please select a file to
			// upload");
			return "/admin/uploads";
		} else {

			System.out.println("---------------------------------------");
			System.out.println(pid);
			System.out.println("-========================================");
			try {

				// Get the file and save it somewhere
				byte[] bytes = file.getBytes();
				Path path = Paths.get(realPath + "../resources/static/uploads/" + file.getOriginalFilename());
				String dbp = "../uploads/" + file.getOriginalFilename();
				Image image = new Image();
				Product byId = psi.getById(Integer.parseInt(pid));
				image.setProduct(byId);
				image.setImagePath(dbp);
				ImageImpl.save(image);

				Files.write(path, bytes);
				System.out.println(path);
				// session.setAttribute("item", byId);
				mm.addAttribute("item", byId);
				// redirectAttributes.addFlashAttribute("message",
				// "You successfully uploaded '" + file.getOriginalFilename() + "'");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "/admin/uploads";
	}

	@RequestMapping("/onepro/{id}")
	public String loadOneProduct(@PathVariable("id") Integer id, ModelMap mm) {
		Product byId = psi.getById(id);
		mm.addAttribute("item", byId);
		return "/product";
	}

	@RequestMapping("/products")
	public String products(ModelMap mm) {
		List<Product> all = psi.getAll();			
		mm.addAttribute("items", all);
		return "/allpro";
	}
	
	@RequestMapping("/productlist")
	public String productlist(ModelMap mm) {
		List<Product> all = psi.getAll();			
		mm.addAttribute("items", all);
		return "admin/allproducts";
	}

}
