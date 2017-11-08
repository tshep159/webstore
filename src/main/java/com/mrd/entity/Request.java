/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.entity;

import javax.persistence.*;

/**
 *
 * @author User
 */
@Entity
@Table(name="request")
public class Request {
 @Id
 @GeneratedValue
 @Column(name="id")
 private Long reqId;
 @Column(name="type")
 private String type;
 private String name;
 private String lname;
 private String email;
 @Column(name="discription")
 private String discription;

    public Request() {
    }

    public Request(Long reqId, String type, String name, String lname, String email, String discription) {
        this.reqId = reqId;
        this.type = type;
        this.name = name;
        this.lname = lname;
        this.email = email;
        this.discription = discription;
    }

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
    
    

 

    
 
}
