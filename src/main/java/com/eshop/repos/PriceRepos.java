package com.eshop.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.entitiy.Price;

public interface PriceRepos extends JpaRepository<Price, Integer> {

}
