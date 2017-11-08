/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.controller;

import com.mrd.entity.Product;
import com.mrd.entity.User;
import com.mrd.service.ProductService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProductController {
   
    @Autowired
    private ProductService prodService;

    List<Product> prodList = new ArrayList<>();
    /*Fecthing all products*/
    @RequestMapping(value="/products/all",method = RequestMethod.GET)
    public List<Product> allProducts(){
      return prodService.listProducts();
    }
    
    /*saving product */
    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product){
        prodService.addProduct(product);
    }

  /*get product by user_id*/
    @RequestMapping(value="/rest/{user_id}/product", produces ={MediaType.APPLICATION_JSON_VALUE}) 
   public Set<Product> byUser(@PathVariable int user_id){
    return prodService.listProduct(user_id);
}
   

}
    

