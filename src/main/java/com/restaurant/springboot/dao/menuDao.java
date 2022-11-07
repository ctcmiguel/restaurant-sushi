package com.restaurant.springboot.dao;

import com.restaurant.springboot.model.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface menuDao extends JpaRepository<Menu, Integer>{
    
}
