package com.eshop.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.entitiy.Shop;
import com.eshop.entitiy.User;

public interface ShopRepos extends JpaRepository<Shop, Integer> {

	List<Shop> findByUser(User u);
	
	
}
