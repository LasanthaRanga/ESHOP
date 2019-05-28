package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eshop.entitiy.Cart;
import com.eshop.repos.CartRepos;
@org.springframework.stereotype.Service
public class CartServiceImpl implements Service<Cart> {

	
	@Autowired
	CartRepos cr;
	
	@Override
	public Cart save(Cart entity) {
		
		return cr.save(entity);
	}

	@Override
	public Cart update(Cart entity) {
		
		return cr.save(entity);
	}

	@Override
	public Cart getById(int i) {
		// TODO Auto-generated method stub
		return cr.getOne(i);
	}

	@Override
	public List<Cart> getAll() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public List<Cart> getAllByStatus(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
