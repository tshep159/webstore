/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.*;

@Entity
@Table(name="restaurant")
public class Restaurant{
    @Id
    @GeneratedValue
    @Column(name="rest_Id")
    private Integer rest_id;
    
    @Column(name="Name")
    private String name;
    @Column(name="discription")
    private String disc;
    @Column(name="street")
    private String street;
    @Column(name="town")
    private String town;
    @Column(name="cell")
    private String cell;
    @Column(name="email")
    private String email;
    @Column(name="image", length=510000)
    private String image;
    
    @Column(name="password")
    private String password;
    @Column(name="active")
    private String active;
//   @OneToMany(mappedBy="restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set <Product> product;

    public Restaurant() {
    }

    public Restaurant(Integer rest_id, String name, String disc, String street, String town, String cell, String email, String image, String password, String active, Set<Product> product) {
        this.rest_id = rest_id;
        this.name = name;
        this.disc = disc;
        this.street = street;
        this.town = town;
        this.cell = cell;
        this.email = email;
        this.image = image;
        this.password = password;
        this.active = active;
//        this.product = product;
    }

    public Integer getRest_id() {
        return rest_id;
    }

    public void setRest_id(Integer rest_id) {
        this.rest_id = rest_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

//    public Set<Product> getProduct() {
//        return product;
//    }
//
//    public void setProduct(Set<Product> product) {
//        this.product = product;
//    }
    



    
    
    
}
