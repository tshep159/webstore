/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.controller;

import com.mrd.entity.Restaurant;

import com.mrd.service.NotificationService;
import com.mrd.service.RestaurantService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RestaurantController{
   @Autowired
    public  RestaurantService restaurantService;

   
    @Autowired
    NotificationService notificationService;
     
    public List<Restaurant> allRestaurants = new ArrayList<>();

    @RequestMapping(method=RequestMethod.GET, value="show/all/restaurant")
    public List<Restaurant> listRestaurant(){
        return restaurantService.findAll();
    }
 
}

