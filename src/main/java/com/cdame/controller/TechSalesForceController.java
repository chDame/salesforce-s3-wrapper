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

import com.cdame.domain.technical.Sobject;
import com.cdame.exception.CpSecurityException;
import com.cdame.exception.CpTechnicalException;
import com.cdame.services.SalesForceService;

@RestController
@RequestMapping("/techSfAPI")
public class TechSalesForceController extends AbstractController {

    private final Logger logger = LoggerFactory.getLogger(TechSalesForceController.class);

    @Autowired
    private SalesForceService salesForceService;

    @RequestMapping(value = "/getObjects", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Sobject> getSObjects() throws CpSecurityException, CpTechnicalException {
	
    	return salesForceService.getAvailableObjects();
    }
    
    @RequestMapping(value = "/getObject", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object getObject(@RequestParam String objectName, @RequestParam String id) throws CpSecurityException, CpTechnicalException {
	
    	return salesForceService.getObject(objectName, id);
    }
    
    @RequestMapping(value = "/executeQuery", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object executeQuery(@RequestParam String query) throws CpSecurityException, CpTechnicalException {
	
    	return salesForceService.executeQuery(query);
    }
    
    @Override
    public Logger getLogger() {
        return logger;
    }

}
