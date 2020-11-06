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

import com.cdame.domain.picklist.PickListValue;
import com.cdame.exception.CpSecurityException;
import com.cdame.exception.CpTechnicalException;
import com.cdame.exception.SalesForceException;
import com.cdame.services.sf.crud.CaseService;

@RestController
@Deprecated
@RequestMapping("/caseAPI")
public class CaseController extends AbstractController {

    private final Logger logger = LoggerFactory.getLogger(CaseController.class);

    @Autowired
    private CaseService caseService;
    
    
    @RequestMapping(value = "/getListValues", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PickListValue> getListValues(@RequestParam String field) throws CpSecurityException, CpTechnicalException, SalesForceException {
    	return caseService.getPickList(field).getPicklistValues();
    }
    
    @Override
    public Logger getLogger() {
        return logger;
    }

}
