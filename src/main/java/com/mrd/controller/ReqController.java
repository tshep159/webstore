package com.mrd.controller;

import com.mrd.entity.Request;
import com.mrd.service.NotificationService;
import com.mrd.service.ReqService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class ReqController {
    
    @Autowired
    ReqService  reqService;
    @Autowired
    NotificationService notificationService;
    /*Posting a Request*/
      @RequestMapping(method = RequestMethod.POST, value = "/request")
    public void Request(@RequestBody Request r){
      reqService.save(r);
      /*using try-catch */ 
      try{
        notificationService.SendRequest(r);
    }catch(MailException e){
        
        }
        System.out.println("request inserted to db");
   }
    /*fetching all requests*/
      @GetMapping("/all/request")
    public List<Request>listRequest()
    {
        return (List<Request>) reqService.findAll();
    }
}
