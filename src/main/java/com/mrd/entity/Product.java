package com.mrd.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.json.JSONObject;
@Entity
@Table(name="product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer product_id;
    @Lob
    @Column(name="image",length=100512)
    private String image;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
   
    @Column(name="price")
    private double price;
    
    @Column(name="active")
    private boolean active= true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="orderDetailsId")
    private OrderDetails orderDetails;

    public Product() {
    }

    public Product(Integer product_id, String image, String name, String description, double price, User user, OrderDetails orderDetails) {
        this.product_id = product_id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.user = user;
        this.orderDetails = orderDetails;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


   

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    // products
    public void setUser(User user){
    	this.user = user;
    }
    
    public User getUser(){
    	return this.user;
    }
    public String toString(){
    	String info = "";
    	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);
        
        JSONObject companyObj = new JSONObject();
        companyObj.put("name", this.user.getFirstName());
        jsonInfo.put("company", companyObj);
        
        info = jsonInfo.toString();
        return info;
    }

}