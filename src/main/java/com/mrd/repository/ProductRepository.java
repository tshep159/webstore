/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.repository;

import com.mrd.entity.Product;
import com.mrd.entity.User;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author User
 */
public interface ProductRepository extends JpaRepository <Product, Integer>{


 @Query("FROM Product WHERE user_id = :user_id")
    Set <Product> findProductByUser(@Param("user_id")int user_id);

}
