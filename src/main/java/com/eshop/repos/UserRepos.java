package com.eshop.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.entitiy.User;

public interface UserRepos extends JpaRepository<User, Integer> {

	List<User> findByUserEmailAndUserPassword(String userEmail, String userPassword);

	User findByUserEmail(String userEmail);
	
	

}
