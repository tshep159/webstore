/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ViewController {
     @RequestMapping(value="/",method=RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String home(){
        return "home";
    }
    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String register(){
        return "register";
    }
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        return "login";
    }   
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String list(){
        return "userlist";
    }
    @RequestMapping(value="/admin",method=RequestMethod.GET)
    public String admin(){
        return "admin";
    }
    /**
     * Request
     */
    @RequestMapping(value="/request", method=RequestMethod.GET)
    public String request(){
        return "request";
    }
    @RequestMapping(value="/addProduct",method=RequestMethod.GET)
    public String addProduct(){
        return "addProduct";
    }
   @RequestMapping(value="/product/all",method=RequestMethod.GET)
    public String productsView(){
        return "products";
    }
    @RequestMapping(value="/adminProduct",method = RequestMethod.GET)
    public String adminViewProduct(){
        return "addProduct";
    }
    @RequestMapping(value="/cart",method=RequestMethod.GET)
    public String cartView(){
        return "cart";
    }
    @RequestMapping(value="/partners/login", method=RequestMethod.GET)
    public String addrest(){
        return "logins";
    }
   
   @RequestMapping(value="/payment", method=RequestMethod.GET)
   public String pay(){
   return "payment";
   }
   @RequestMapping(value="/address", method=RequestMethod.GET)
    public String address(){
        return "address";
    }
   @RequestMapping(value="/show/restaurant/{user_id}/products", method=RequestMethod.GET)
   public String dispId(Long rest_id){
   return "prod";
   }
  @RequestMapping(value="/driver", method = RequestMethod.GET)
   public String adriver(){
   return "driver";
   }
   @RequestMapping(value="/user-list", method= RequestMethod.GET)
   public String edit(){
       return "user-list";
   }
   @RequestMapping(value="/userproduct", method=RequestMethod.GET)
   public String uproduct(){
       return "uproduct";
   }
   @RequestMapping(value="/rest", method=RequestMethod.GET)
   public String re(){
       return "rest";
   }
   }
