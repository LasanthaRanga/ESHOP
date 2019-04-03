package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eshop.entitiy.Subcat2;
import com.eshop.repos.Subcat2Repos;

@org.springframework.stereotype.Service
public class Subcat2ServiceImpl implements Service<Subcat2> {

	@Autowired
	Subcat2Repos sc2Repos;
	
	@Override
	public Subcat2 save(Subcat2 entity) {		
		return sc2Repos.save(entity);
	}

	@Override
	public Subcat2 update(Subcat2 entity) {		
		return sc2Repos.save(entity);
	}

	@Override
	public Subcat2 getById(int i) {		
		return sc2Repos.findById(i).get();
	}

	@Override
	public List<Subcat2> getAll() {
		return sc2Repos.findAll();
	}

	@Override
	public List<Subcat2> getAllByStatus(int i) {
		return null;
	}

}
