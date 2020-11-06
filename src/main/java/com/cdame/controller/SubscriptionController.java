package com.cdame.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cdame.domain.Account;
import com.cdame.domain.Subscription;
import com.cdame.exception.CpSecurityException;
import com.cdame.exception.CpTechnicalException;
import com.cdame.services.sf.crud.AccountService;
import com.cdame.services.sf.crud.SubscriptionService;

@RestController
@RequestMapping("/subscriptionAPI")
public class SubscriptionController extends AbstractController {

    private final Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

    @Autowired
    private AccountService accountService;
    @Autowired
    private SubscriptionService subscriptionService; 
    
    @RequestMapping(value = "/getSubscriptions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Subscription> getSubscriptions(@RequestParam String  contactId) throws CpSecurityException, CpTechnicalException {
    	
    	return subscriptionService.getSubscriptionsByContact(contactId);
    }
    
  
    
    @RequestMapping(value = "/getAccount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Account getAccount(@RequestParam String accountId) throws CpSecurityException, CpTechnicalException {
    	return accountService.getNormalizedObject(accountId);
    }

    
   
    
    @Override
    public Logger getLogger() {
        return logger;
    }

}
