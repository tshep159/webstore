/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.service;

import com.mrd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mrd.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tshepo
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    /*find all users*/
    public Object findAll(){
    return userRepository.findAll();
    }
 
    /*add user*/
    public User save(User user){
   
        return userRepository.save(user);
    }
   
    public List<User> getUsers(){
        List<User> u = new ArrayList<>();
        userRepository.findAll().forEach(u::add);
        return u;
    }
    
  
     public User login(String email,String password){
        User customer =  null;
        String status = null;
          List<User> customers = getUsers();
          for(int i = 0;i< customers.size();i++){
              if(customers.get(i).getEmail().equals(email) && customers.get(i).getPassword().equals(password)){
                  status = "LoggedIn";
                  customer = customers.get(i);
                  break;
              }else{
                  status = "Invalid Credentials";
              }
          }
          return customer;
    }
  

     
      public User update(User user) {
        return userRepository.save(user);
    }


    public List <User> listRestaurants(String role) {
  return userRepository.findAllByRole(role);
    }

       public void delete(User u){
        userRepository.delete(u);
    }
        public String save(int user_id, User user) {
            User u = userRepository.findOne(user_id);
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setEmail(user.getEmail());
            u.setRole(user.getRole());
            u.setContactNumber(user.getContactNumber());
            u.setPassword(user.getPassword());
    
        userRepository.save( u);
    return "success";
    } 
  
}
