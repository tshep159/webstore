/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrd.service;

import com.mrd.entity.OrderDetails;
import com.mrd.entity.Request;
import com.mrd.entity.Restaurant;
import com.mrd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */

@Service
public class NotificationService {
    @Autowired
    private JavaMailSender javamailsender;


//sending notification

public void sendNotification(User user) throws MailException{
//send email
SimpleMailMessage mail = new SimpleMailMessage();
mail.setTo(user.getEmail());
mail.setFrom("info@mrdelivery.com");
mail.setSubject("Thank You For registering");
mail.setText("\n Your account details are as follows \n Username : "+user.getEmail() +"\n Password : "+user.getPassword()+""+"");

javamailsender.send(mail);
}

public void SendRequest(Request req) throws MailException{
    
    SimpleMailMessage mail = new SimpleMailMessage();
    
    mail.setTo(req.getEmail());
    mail.setFrom("request@mrdelivery.com");
    mail.setSubject("New Request From Website");
    mail.setText("\n Your account details are as follows \n keep checking: "+req.getEmail() +"\n For updates");

}


public void orderNotification(OrderDetails  details) throws MailException{
//send email
SimpleMailMessage mail = new SimpleMailMessage();
mail.setTo(details.getEmail());
mail.setFrom("order@mrdelivery.com");
mail.setSubject("Thank You For Ordering");
mail.setText("\n Your order is being proccessed \n please keep checking your emails for further notifications\n"
        + " Order No : "+details.getOrderDetailsId() 
        +"\n Product : "+details.getName()
        +"\n amount : R"+details.getPrice()
        +"");

javamailsender.send(mail);
}


public void orderStatus(OrderDetails  details) throws MailException{
//send email
SimpleMailMessage mail = new SimpleMailMessage();
mail.setTo(details.getEmail());
mail.setFrom("order@mrdelivery.com");
mail.setSubject("Order Status");
mail.setText("\n Your order has been processed and the status is \n"
        + " Order No : "+details.getOrderDetailsId() 
        +"\n Status : "+details.getStatus()
        +"\n amount : R"+details.getPrice()
        +"");

javamailsender.send(mail);
}







}

