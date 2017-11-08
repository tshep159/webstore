
package com.mrd.repository;


import com.mrd.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface PaymentsRepository extends JpaRepository <Payments, Long> {
    
}
