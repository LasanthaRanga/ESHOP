package com.eshop.service;

import java.util.List;

import com.eshop.entitiy.Shop;
import com.eshop.entitiy.User;

public interface Service<Entity> {

	Entity save(Entity entity);

	Entity update(Entity entity);

	Entity getById(int i);

	List<Entity> getAll();

	List<Entity> getAllByStatus(int i);

	
}
