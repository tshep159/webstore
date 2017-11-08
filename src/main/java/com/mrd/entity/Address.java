
package com.mrd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5798855191565240782L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/*------------*/
        @ManyToOne
	private User user;
	

	@Column(name = "address_line_one")
	@NotBlank(message = "Please enter address line one")
	private String addressLineOne;
	@Column(name = "address_line_two")
	@NotBlank(message = "Please enter address line two")
	private String addressLineTwo;
	@NotBlank(message = "Please enter city")
	private String city;
	@NotBlank(message = "Please enter state")
	private String state;
	private String country;
	@Column(name = "postal_code")
	@NotBlank(message = "Please enter postal code")
	private String postalCode;
//	private boolean shipping;
//	private boolean billing;
        
        @Column(name = "email")
	private String email;
         @Column(name="orderDetailsId")
    private Long orderDetailsId;
	public Address() {
	}

    public Address(int id, User user, String addressLineOne, String addressLineTwo, String city, String state, String country, String postalCode, String email, Long orderDetailsId) {
        this.id = id;
        this.user = user;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
//        this.shipping = shipping;
//        this.billing = billing;
        this.email = email;
        this.orderDetailsId = orderDetailsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
//
//    public boolean isShipping() {
//        return shipping;
//    }
//
//    public void setShipping(boolean shipping) {
//        this.shipping = shipping;
//    }
//
//    public boolean isBilling() {
//        return billing;
//    }
//
//    public void setBilling(boolean billing) {
//        this.billing = billing;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Long orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

        
        
}