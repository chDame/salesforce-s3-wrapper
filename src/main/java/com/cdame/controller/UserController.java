package com.cdame.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cdame.exception.CpSecurityException;
import com.cdame.exception.CpTechnicalException;
import com.cdame.services.sf.crud.ContactService;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/image", method = RequestMethod.GET, produces = "application/octet-stream")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<InputStreamResource> getUserImage(@RequestParam String contactId) throws CpSecurityException, CpTechnicalException {
    	try {
			byte[] content = contactService.getContactPhoto(contactId);
			InputStream is = new ByteArrayInputStream(content);
	        return ResponseEntity.ok()
	                .contentLength(content.length)
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .body(new InputStreamResource(is));
        
	    } catch (Exception e) {
	        throw new CpTechnicalException("Image retrieval failed", e);
	    }
    }
    
    
    @Override
    public Logger getLogger() {
        return logger;
    }

}
