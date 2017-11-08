/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.service;


//import com.mrd.entity.Address;
import com.mrd.entity.OrderDetails;
import com.mrd.entity.Payments;
import com.mrd.repository.OrderDetailsRepository;
import java.util.List;
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class OrderService {
    
    
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
   
       /*find all OrderDetails*/
   
  public Object findAll(){
    return orderDetailsRepository.findAll();
    }
 
 /*add OrderDetails*/
    public OrderDetails save(OrderDetails orderDetails){
       
        OrderDetails orOBJ = new OrderDetails();

        /*order*/
        
        orOBJ.setEmail(orderDetails.getEmail());
        orOBJ.setDateCreated(orderDetails.getDateCreated());
        orOBJ.setStatus(orderDetails.getStatus());
//        orOBJ.setType(orderDetails.getType());
       orOBJ.setProduct(orderDetails.getProduct());
        orOBJ.setName(orderDetails.getName());
        orOBJ.setPrice(orderDetails.getPrice());
      
       // orOBJ.setAddress(orderDetails.getAddress());
        
        return orderDetailsRepository.save(orOBJ);
    }
 
   public void updateUserOrder(Long id, OrderDetails userOrders)
    {

        orderDetailsRepository.save(userOrders);
    }

    public void save(long orderDetailsId, OrderDetails details) {
   orderDetailsRepository.save(details);
    }
}
