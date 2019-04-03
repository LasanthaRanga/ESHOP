package com.eshop.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.entitiy.Shop;

public interface ShopRepos extends JpaRepository<Shop, Integer> {

}
