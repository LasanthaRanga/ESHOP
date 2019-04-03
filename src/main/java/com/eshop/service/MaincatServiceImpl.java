package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eshop.entitiy.Maincat;
import com.eshop.repos.MaincatRepos;
@org.springframework.stereotype.Service
public class MaincatServiceImpl implements Service<Maincat> {
	@Autowired
	MaincatRepos mcr;
	
	@Override
	public Maincat save(Maincat entity) {
		
		return mcr.save(entity);
	}

	@Override
	public Maincat update(Maincat entity) {
		// TODO Auto-generated method stub
		return mcr.save(entity);
	}

	@Override
	public Maincat getById(int i) {			
		return mcr.findById(i).get();
	}

	@Override
	public List<Maincat> getAll() {
		// TODO Auto-generated method stub
		return mcr.findAll();
	}

	@Override
	public List<Maincat> getAllByStatus(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
