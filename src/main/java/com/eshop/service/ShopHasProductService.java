package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eshop.entitiy.Shophasproduct;
import com.eshop.repos.ShopHasProductRepos;

@org.springframework.stereotype.Service
public class ShopHasProductService implements Service<Shophasproduct> {

	@Autowired
	ShopHasProductRepos shpr;
	
	@Override
	public Shophasproduct save(Shophasproduct entity) {
		// TODO Auto-generated method stub
		return shpr.save(entity);
	}

	@Override
	public Shophasproduct update(Shophasproduct entity) {
		// TODO Auto-generated method stub
		return shpr.save(entity);
	}

	@Override
	public Shophasproduct getById(int i) {
		// TODO Auto-generated method stub
		return shpr.getOne(i);
	}

	@Override
	public List<Shophasproduct> getAll() {
		// TODO Auto-generated method stub
		return shpr.findAll();
	}

	@Override
	public List<Shophasproduct> getAllByStatus(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
