
package com.mrd.service;

import com.mrd.entity.Payments;
import com.mrd.repository.PaymentsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */


@Service
public class PaymentService {
 
    
     @Autowired
    private PaymentsRepository paymentsRepository;
    
    public List<Payments> listPayments(){
        List<Payments> allPayments = new ArrayList<>();
        paymentsRepository.findAll().forEach(allPayments::add);
        return allPayments;
    }
    
    public void addPayment(Payments payments){
        paymentsRepository.save(payments);
    }
    
    public void removePayment(Payments payments){
        paymentsRepository.delete(payments);
    }
}
