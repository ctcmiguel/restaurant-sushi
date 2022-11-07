package com.restaurant.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.springboot.model.Menu;
import com.restaurant.springboot.model.Orders;
import com.restaurant.springboot.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public Menu AddMenu(@RequestBody Menu newMenu){
    return menuService.AddMenu(newMenu);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{menuId}")
    public Menu GetMenuById(@PathVariable("menuId") int menuId){
        return menuService.GetMenubyId(menuId);
    } 

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public Menu UpdateMenu(@RequestBody Menu updateMenu){
    return menuService.UpdateMenu(updateMenu);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{menuId}")
    public void DeleteMenu(@PathVariable("menuId") int menuId){
        menuService.deleteMenu(menuId);

    }

    // @RequestMapping(method = RequestMethod.GET, value = "/{orderId}")
    // public Orders GetOrderbyId(@PathVariable("orderId") int orderId){
    //     return menuService.GetOrderbyId(orderId);
    // }
   
}
