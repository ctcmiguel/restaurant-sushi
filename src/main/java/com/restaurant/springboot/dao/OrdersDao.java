package com.restaurant.springboot.dao;

import org.springframework.stereotype.Repository;

import com.restaurant.springboot.model.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer> {
    
}
