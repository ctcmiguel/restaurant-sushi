package com.restaurant.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import com.restaurant.springboot.dao.OrdersDao;
import com.restaurant.springboot.dao.menuDao;
import com.restaurant.springboot.model.Menu;
import com.restaurant.springboot.model.Orders;

// import net.bytebuddy.asm.Advice.Return;

@Service
public class MenuService {

    @Autowired
    private menuDao menuDao;

    @Autowired
    private OrdersDao ordersDao;
    
    @Transactional(propagation = Propagation.REQUIRED)
    public Menu AddMenu(Menu newMenu){
       
        Optional<Orders> foundOrder = ordersDao.findById(newMenu.getOrders().getOrderId());
        Orders orders;

        if(foundOrder.isEmpty()){
            orders = ordersDao.save(new Orders());
        }else{
            orders = foundOrder.get();
        }
        newMenu.getOrders().setOrderId(orders.getOrderId());
        return menuDao.save(newMenu);
    }


    public Menu GetMenubyId(int id){
        Optional<Menu> foundMenu = menuDao.findById(id);

        if (foundMenu.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "the Item in the menu was not found");
        }else{
            return foundMenu.get();
        }
    }

    public Menu UpdateMenu(Menu updateMenu){
       GetMenubyId(updateMenu.getId());

        return menuDao.save(updateMenu);

    }

    public void deleteMenu(int id){
        Menu found = GetMenubyId(id);

        menuDao.delete(found);
    }

    public Orders GetOrderbyId(int orderId){
        Optional<Orders> foundOrder = ordersDao.findById(orderId);

        if (foundOrder.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no order found with this id");
        }else{
            return foundOrder.get();
        }
    }  
 
    
}
