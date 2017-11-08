/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.repository;


import com.mrd.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface UserRepository extends CrudRepository <User, Integer> {
   
    
     @Query("SELECT u from User u where u.email = :email AND u.password = :password")
   public User findByEmailAndPassword(String email ,String password );
    
public List<User> findAllByRole(String role);

    
}
