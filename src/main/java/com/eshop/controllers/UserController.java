package com.eshop.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eshop.entitiy.Image;
import com.eshop.entitiy.Product;
import com.eshop.entitiy.User;
import com.eshop.service.UserServiceImpl;
import com.eshop.util.EmailUtilImpl;

@Controller
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	EmailUtilImpl esu;
	

	@RequestMapping("/singup")
	public String singup() {
		return "SingUp";
	}

	@RequestMapping("/loginpage")
	public String goTologin() {
		return "login";
	}

	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user, ModelMap modleMap) {
		if (!userServiceImpl.isUserinthisEmail(user.getUserEmail())) {
			if (user.getUserPassword().equals(user.getUserAddress3())) {
				user.setUserAddress3(null);
				User save = userServiceImpl.save(user);
				new Thread() {
					public void run() {
						System.out.println("THREAD");
					};
				}.start();
				String msg = "SingUp Seccess : " + save.getIdUser();
				modleMap.addAttribute("msg", msg);
				return "login";
			} else {
				modleMap.addAttribute("pword", "Passwords Are Not Equals Please Recheck");
				return "SingUp";
			}
		} else {
			modleMap.addAttribute("pword", "This User Name All rady Exsist please sing in your email");
			return "SingUp";
		}
	}

	@RequestMapping("/allusers")
	public String goToAllUsers(ModelMap modelmap) {
		List<User> all = userServiceImpl.getAll();
		modelmap.addAttribute("users", all);
		return "/admin/allusers";
	}

	@GetMapping("/selectUser/{uid}")
	public String selectUser(@PathVariable("uid") int uid, ModelMap modelmap) {
		System.out.println("awa   "+uid);
		User byId = userServiceImpl.getById(uid);
		modelmap.addAttribute("user", byId);
		return "/admin/selectedUser";
	}

	@RequestMapping("/login")
	public String login(HttpSession session, ModelMap modelmap, @ModelAttribute("user") User user) {
		User userByLogin = userServiceImpl.getUserByLogin(user.getUserEmail(), user.getUserPassword());
		String path = "";
		if (userByLogin != null) {

			session.setAttribute("user", userByLogin);
			session.setAttribute("ut", userByLogin.getUsertype().getIdUserType());
			modelmap.addAttribute("user", userByLogin);

			if (userByLogin.getUsertype().getIdUserType() == 1) {
				System.out.println("ADMIN");
				path = "/admin/dashboard";
			} else if (userByLogin.getUsertype().getIdUserType() == 2) {
				System.out.println("Reseller");
				path = "/admin/dashboard";
			} else if (userByLogin.getUsertype().getIdUserType() == 3) {
				System.out.println("Supplier");
				path = "/admin/dashboard";
			} else if (userByLogin.getUsertype().getIdUserType() == 4) {
				System.out.println("Customer");
				path = "/admin/dashboard";
			} else {
				path = "login";
			}
		} else {
			modelmap.addAttribute("message", "Recheack Your Email and Password");
			path = "login";
		}
		return path;
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("ut");
		session.invalidate();
		return "/index";
	}
	
	@RequestMapping("/profile")
	public String profile(HttpSession session,ModelMap modelmap){
		User u = (com.eshop.entitiy.User)session.getAttribute("user");
		modelmap.addAttribute("user",u);
		return"/admin/profile";
	}
	
	
	@RequestMapping("/update")
	public String updateUser(HttpSession session,ModelMap modelmap, @ModelAttribute("user") User user){
		User u = (com.eshop.entitiy.User)session.getAttribute("user");
		System.out.println(u.getIdUser()+"      id USER");
		user.setIdUser(u.getIdUser());
		user.setUsertype(u.getUsertype());
		user.setUserEmail(u.getUserEmail());
		user.setUserPassword(u.getUserPassword());
		user.setUserStatus(u.getUserStatus());
		
		User update = userServiceImpl.update(user);		
		modelmap.addAttribute("user",update);
		return"/admin/profile";
	}
	
	@PostMapping("/uploadProPic") // //new annotation since 4.3
	public String proPicUpload(@RequestParam("file") MultipartFile file, @RequestParam("uid") String uid,
			HttpServletRequest request, ModelMap mm) {

		String realPath = request.getServletContext().getRealPath("/");

		if (file.isEmpty()) {
			// redirectAttributes.addFlashAttribute("message", "Please select a file to
			// upload");
			return "/admin/profile";
		} else {

			System.out.println("---------------------------------------");
			System.out.println(uid);
			System.out.println("-========================================");
			try {

				// Get the file and save it somewhere
				byte[] bytes = file.getBytes();
				Path path = Paths.get(realPath + "../resources/static/uploads/propic/" + file.getOriginalFilename());
				String dbp = "../uploads/propic/" + file.getOriginalFilename();
				Image image = new Image();
				User userbyid = userServiceImpl.getById(Integer.parseInt(uid));				
				userbyid.setUserPic(dbp);
				userServiceImpl.update(userbyid);

				Files.write(path, bytes);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "/admin/profile";
	}
	
	
	@RequestMapping("/logsettings")
	public String allLogins(ModelMap modelmap) {
		List<User> all = userServiceImpl.getAll();
		modelmap.addAttribute("users", all);
		return "/logsettings";
	}

}
