 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.service;

//import com.mrd.entity.ShippingAddress;
//import com.mrd.entity.Address;
import com.mrd.entity.Address;
import com.mrd.entity.OrderDetails;
import com.mrd.entity.User;
import com.mrd.repository.ShippingAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class AddressService {
    @Autowired
    ShippingAddressRepository ar;
    
    
    public Object findAll(){
        return ar.findAll();
    }
//    
    public Address save(Address sa){
      
        return ar.save(sa);
    }
//    
//    
    
}
