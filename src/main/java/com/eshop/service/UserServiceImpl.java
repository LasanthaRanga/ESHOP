package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import com.eshop.entitiy.User;
import com.eshop.repos.UserRepos;
import com.eshop.repos.UserTypeRepos;

@org.springframework.stereotype.Service
public class UserServiceImpl implements Service<User> {

	@Autowired
	private UserRepos userRepo;
	
	@Autowired
	private UserTypeRepos utRepos;
	
	
	
	@Override
	public User save(User entity) {
		com.eshop.entitiy.Usertype usertype = utRepos.findById(4).get();
		entity.setUsertype(usertype);
		entity.setUserStatus(1);
		userRepo.save(entity);
		return entity;
	}

	@Override
	public User update(User entity) {		
		return userRepo.save(entity);
	}

	@Override
	public User getById(int i) {
		return userRepo.findById(i).get();		 
	}

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
		
	}

	@Override
	public List<User> getAllByStatus(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByLogin(String userEmail, String userPassword) {
		List<User> findByUserEmailAndUserPassword = userRepo.findByUserEmailAndUserPassword(userEmail, userPassword);
		User u = null;
		System.out.println("siZe "+findByUserEmailAndUserPassword.size());
		for (User user : findByUserEmailAndUserPassword) {
			System.out.println(user.getIdUser());
			u = user;
		}
		return u;
		
	}
	
	
	public boolean isUserinthisEmail(String userEmail) {
		User findByUserEmail = userRepo.findByUserEmail(userEmail);
		if(findByUserEmail!=null) {return true;}else {return false;}
	}

}
