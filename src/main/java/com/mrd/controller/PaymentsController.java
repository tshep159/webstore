/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.controller;

import com.mrd.entity.Address;
import com.mrd.entity.Payments;
import com.mrd.service.AddressService;
import com.mrd.service.PaymentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */


@RestController
public class PaymentsController {
    
  @Autowired
  PaymentService paymentService;

    @Autowired
  AddressService addressService;
List <Payments> availPayments= new ArrayList<>();  
    
    
@GetMapping("/all/payments")
 public List <Payments> allPayments(){
     return paymentService.listPayments();
 }   
    
 



}

 