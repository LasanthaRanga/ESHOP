package com.eshop.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import com.eshop.entitiy.Image;
import com.eshop.repos.ImageRepos;
@org.springframework.stereotype.Service
public class ImageServiceImpl implements Service<Image> {

	@Autowired
	ImageRepos ir;
	
	@Override
	public Image save(Image entity) {		
		return ir.save(entity);
	}

	@Override
	public Image update(Image entity) {
		// TODO Auto-generated method stub
		return ir.save(entity);
	}

	@Override
	public Image getById(int i) {
		// TODO Auto-generated method stub
		return ir.getOne(i );
	}

	@Override
	public List<Image> getAll() {		
		return ir.findAll();
	}

	@Override
	public List<Image> getAllByStatus(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
