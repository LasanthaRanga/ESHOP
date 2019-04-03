package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eshop.entitiy.Price;
import com.eshop.repos.PriceRepos;
@org.springframework.stereotype.Service
public class PriceServiceImpl implements Service<Price> {

	
	@Autowired
	PriceRepos pr;
	
	@Override
	public Price save(Price entity) {		
		return pr.save(entity);
	}

	@Override
	public Price update(Price entity) {
		return pr.save(entity);
	}

	@Override
	public Price getById(int i) {
		return pr.getOne(i);
	}

	@Override
	public List<Price> getAll() {
		return	pr.findAll();
	}

	@Override
	public List<Price> getAllByStatus(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
