package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eshop.entitiy.Product;
import com.eshop.repos.ProductRepos;
@org.springframework.stereotype.Service
public class ProductServiceImpl implements Service<Product> {

	@Autowired
	ProductRepos pr;
	
	@Override
	public Product save(Product entity) {		
		return pr.save(entity);
	}

	@Override
	public Product update(Product entity) {
		// TODO Auto-generated method stub
		return pr.save(entity);
	}

	@Override
	public Product getById(int i) {
		// TODO Auto-generated method stub
		return pr.findById(i).get();
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public List<Product> getAllByStatus(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
