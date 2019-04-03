package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eshop.entitiy.Subcat1;
import com.eshop.repos.Subcat1Repos;

@org.springframework.stereotype.Service
public class Subcat1ServiceImpl implements Service<Subcat1> {

	@Autowired
	Subcat1Repos sc1Repos;
	
	@Override
	public Subcat1 save(Subcat1 entity) {
		Subcat1 save = sc1Repos.save(entity);
		return save;
	}

	@Override
	public Subcat1 update(Subcat1 entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subcat1 getById(int i) {		
		return sc1Repos.findById(i).get();
	}

	@Override
	public List<Subcat1> getAll() {		
		return sc1Repos.findAll();
	}
	
	
	@Override
	public List<Subcat1> getAllByStatus(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
