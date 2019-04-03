package com.eshop.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.entitiy.Product;

public interface ProductRepos extends JpaRepository<Product, Integer> {

}
