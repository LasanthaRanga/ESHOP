package com.eshop.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.entitiy.Cart;

public interface CartRepos extends JpaRepository<Cart, Integer> {

}
