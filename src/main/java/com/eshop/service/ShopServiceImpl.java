package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eshop.entitiy.Shop;
import com.eshop.repos.ShopRepos;

@org.springframework.stereotype.Service
public class ShopServiceImpl implements Service<Shop> {

	@Autowired
	ShopRepos shopRepo;
	
	@Override
	public Shop save(Shop entity) {
		return shopRepo.save(entity);
	}

	@Override
	public Shop update(Shop entity) {		
		return shopRepo.save(entity);
	}

	@Override
	public Shop getById(int i) {		
		return shopRepo.findById(i).get();
	}

	@Override
	public List<Shop> getAll() {		
		return shopRepo.findAll();
	}

	@Override
	public List<Shop> getAllByStatus(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
