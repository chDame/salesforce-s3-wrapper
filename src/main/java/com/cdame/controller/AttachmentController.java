package com.cdame.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cdame.exception.CpTechnicalException;
import com.cdame.services.AwsS3Service;

@RestController
@RequestMapping("/attachments")
public class AttachmentController extends AbstractController {

    private final Logger logger = LoggerFactory.getLogger(AttachmentController.class);

    @Autowired
    private AwsS3Service s3Service;
    
    @RequestMapping(value = "/listBuckets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String[] listBuckets() {
    	return s3Service.listBuckets();
    }
    
    @RequestMapping(value = "/listObjects", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String[] listObjects(@RequestParam String bucketName) {
    	return s3Service.listObjects(bucketName);
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<InputStreamResource> download(@RequestParam String bucket, @RequestParam String key) throws CpTechnicalException {
		try {
			InputStream is = s3Service.getFile(bucket, key);

			HttpHeaders header = new HttpHeaders();
	        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+key.substring(36));
	        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
	        header.add("Pragma", "no-cache");
	        header.add("Expires", "0");
			
	        return ResponseEntity.ok()
	        		.headers(header)
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .body(new InputStreamResource(is));
        
	    } catch (Exception e) {
	        throw new CpTechnicalException("Image upload failed", e);
	    }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> upload(@RequestHeader String bucket, @RequestHeader String filename, HttpServletRequest request)
            throws CpTechnicalException {

    	String key;
		try {
			key = s3Service.sendFile(bucket, filename, request.getInputStream(), request.getContentLength());

       
        	Map<String, String> result = new HashMap<>();
        	result.put("key", key);
        	return result;		
		} catch (IOException e) {
    		throw new CpTechnicalException(e.getMessage());
    	}

    }


    @Override
    public Logger getLogger() {
        return logger;
    }
}
