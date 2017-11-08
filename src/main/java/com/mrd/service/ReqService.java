/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.service;

import com.mrd.entity.Request;
import com.mrd.repository.RequestRepo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class ReqService {
    
        @Autowired
    private RequestRepo requestRepo;
    /*find all users*/
    public Object findAll(){
    return requestRepo.findAll();
    }
 
    /*add user*/
    public Request save(Request r){
        return requestRepo.save(r);
    }
   
    public List<Request> getUsers(){
        List<Request> r = new ArrayList<>();
        requestRepo.findAll().forEach(r::add);
        return r;
    }
    
    
    
}
