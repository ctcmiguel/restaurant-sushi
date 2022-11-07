package com.restaurant.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name= "Menu")
public @Data class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private int price;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Orders orders;

    public Menu (){

    }
     public Menu(int id){
        this.id = id;
     }

     public Menu(String name, String description, int price){
        this.name = name;
        this.description = description;
        this.price = price;
     }
    
    
}
