package com.eshop.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.entitiy.Carthasproduct;

public interface CartHasProductRepos extends JpaRepository<Carthasproduct, Integer> {

}
