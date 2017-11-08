/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.service;

import com.mrd.entity.Product;
import com.mrd.repository.ProductRepository;
import com.mrd.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LebyanaWT
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository prodRep;
    @Autowired
    private UserRepository userRepository;
    public List<Product> listProducts(){
        List<Product> allProducts = new ArrayList<>();
        prodRep.findAll().forEach(allProducts::add);
        return allProducts;
    }
    
    public void addProduct(Product prod){
    prodRep.save(prod);
    }
    
    public void removeProd(Product prod){
        prodRep.delete(prod);
    }

 public Set <Product> listProduct(int user_id) {
  
  return  prodRep.findProductByUser(user_id);
  
    }

 
}