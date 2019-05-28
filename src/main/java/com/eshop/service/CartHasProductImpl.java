package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eshop.entitiy.Carthasproduct;
import com.eshop.repos.CartHasProductRepos;
@org.springframework.stereotype.Service
public class CartHasProductImpl implements Service<Carthasproduct> {

	@Autowired
	CartHasProductRepos chpr;
	
	@Override
	public Carthasproduct save(Carthasproduct entity) {
		// TODO Auto-generated method stub
		return chpr.save(entity);
	}

	@Override
	public Carthasproduct update(Carthasproduct entity) {
		// TODO Auto-generated method stub
		return chpr.save(entity);
	}

	@Override
	public Carthasproduct getById(int i) {
		// TODO Auto-generated method stub
		return chpr.getOne(i);
	}

	@Override
	public List<Carthasproduct> getAll() {
		// TODO Auto-generated method stub
		return chpr.findAll();
	}

	@Override
	public List<Carthasproduct> getAllByStatus(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
