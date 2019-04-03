package com.eshop.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.entitiy.Image;

public interface ImageRepos extends JpaRepository<Image, Integer> {

}
