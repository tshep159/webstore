/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.controller;

import com.mrd.entity.*;
import com.mrd.service.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */

@RestController

public class OrderController {
//    
    @Autowired
    OrderService orderService;
    @Autowired
    AddressService addressService;
      @Autowired
     NotificationService notificationService;
//    @Autowired 
//    UserService userService;
//    @Autowired
//    ProductService productService;
//    
 public List<OrderDetails> allOrders= new ArrayList<>(); 
//   
@RequestMapping(value="/checkout",method = RequestMethod.POST)
public void checkout(@RequestBody OrderDetails details){
System.out.println("trying to send email"+ details.getEmail());
     
     try{
        notificationService.orderNotification(details);
        }catch(MailException e){
           
            }
            System.out.println("data inserted to db");   
       orderService.save(details);
 }
//@RequestMapping(value="/add/address", method=RequestMethod.POST)
//public void shipping(@RequestBody Address address){
//    addressService.save(address);
//}   


 @GetMapping("/order/list")
    public List<OrderDetails>orderList()
    {
     return (List<OrderDetails>) orderService.findAll();
    }
    

	//@PutMapping(value = "order/update/{id}")
        @RequestMapping(value="order/update/{orderDetailsId}",method = RequestMethod.POST)
	public String postCustomer(@PathVariable long orderDetailsId, @RequestBody OrderDetails details) {
		                System.out.println("trying to send email"+ details.getEmail());
                 try{
                         //  System.out.println("trying to send email"+ details.getEmail());
        notificationService.orderStatus(details);
               
        }catch(MailException e){
           
            }
            System.out.println("data inserted to db");   
		
	
        orderService.save(orderDetailsId, details);
        return "Update Successfully!";
        }
        


}



