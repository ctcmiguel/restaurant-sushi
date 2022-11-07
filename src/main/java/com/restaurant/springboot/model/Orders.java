package com.restaurant.springboot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;



@Entity
public @Data class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private int total; 

    @OneToMany(mappedBy = "orders")
    private List<Menu> menus;
 
    public Orders(){
        this.total = 0;
    }
    public Orders( int orderId){
        this.orderId = orderId;
    }
    public Orders(List<Menu> menus) {
        this.menus = menus;
    }

   
    
}
