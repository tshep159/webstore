/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.controller;

import com.mrd.entity.User;
import com.mrd.service.NotificationService;
import com.mrd.service.ProductService;
import com.mrd.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class UserController {

    @Autowired
    public  UserService userService;
    public List<User> custAvailable = new ArrayList<>();
  
    @Autowired
    NotificationService  notificationService;
    @Autowired
    ProductService productService;
    
   
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public void Register(@RequestBody User user){
        
 //User cus = new User(status, status, status, status, status, status);
   // userRepository.findAll();

         /*generating user password*/
         Random rand= new Random();
    for (int idx = 1; idx <= 10; ++idx){
           int randomInt = rand.nextInt(1000);
           String pass="";
           pass=String.valueOf(rand).toLowerCase();
           user.setPassword(pass);
            userService.save(user);
    try{
        notificationService.sendNotification(user);
    }catch(MailException e){
       // logger.info("email error"+ e.getMessage());
        //  System.out.println("chech email settings");   
        }
        System.out.println("data inserted to db");   
    break;
}

}
    
 @GetMapping("list/list")
public List<User>listCustomer()
{
    return (List<User>) userService.findAll();
}
    
    
@RequestMapping(value="/login/user", produces ={MediaType.APPLICATION_JSON_VALUE})
public User login(@RequestParam String email,String password ){
  return userService.login(email, password);
}
        
        
        
//@RequestMapping("/show/user/{user_id}/products")
//@ResponseBody
//public List<Product> getProductsByRestaurant(@PathVariable Integer user_id) {
//  return productService.listActiveProductsByCategory(user_id);
//}
 
@RequestMapping(value="/user/{user_id}",produces ={MediaType.APPLICATION_JSON_VALUE})
@ResponseBody
    public User update(User user) {
    return userService.update(user);
}
@RequestMapping("/role/{role}") 
public List<User> byRole(@PathVariable(value="role")String role){
   return userService.listRestaurants(role);
}
@RequestMapping(value="/remove/{user_id}", method=RequestMethod.DELETE )
@ResponseBody
    public void delete(User u) {
    userService.delete(u);
}
   @RequestMapping(method = RequestMethod.POST, value = "/update/{user_id}")
	public String postCustomer(@PathVariable int user_id, @RequestBody User user) {
		userService.save(user_id, user);
		return "Update Successfully!";
	}
}

