/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.repository;


import com.mrd.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface PaymentsRepository extends JpaRepository <Payments, Long> {
    
}
