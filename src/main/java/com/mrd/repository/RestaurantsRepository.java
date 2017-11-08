/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.repository;

import com.mrd.entity.Product;
import com.mrd.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author User
 */
public interface RestaurantsRepository extends JpaRepository <Restaurant, Long>{
           //displaying * active products
         
         // public Restaurant get(int id);
//    @Query("SELECT p from Product p where p.id = :rest_id ")
//    public Restaurant get(Long rest_id);

       
  @Query("SELECT u from User u where u.email = :email AND u.password = :password")
    public Restaurant findByEmailAndPassword(String email ,String password );

}
