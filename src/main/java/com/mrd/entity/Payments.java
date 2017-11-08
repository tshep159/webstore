/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 *
 * @author User
 */

@Entity
@Table(name="payments")
public class Payments {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="paymentId")
    private Long paymentId;
    
    @Column(name="cardHoler")
    private String holder;
    
    @Column(name="cardNumber")
    private String number;
    
    @Column(name="expDate")
    private String exp;
    
    @Column(name="cvv")
    private String cvv;
    
      @ManyToOne
	private User user;
    
    /*getters and setters*/

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

   
    
    
    
    
}
