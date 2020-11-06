package com.cdame.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cdame.exception.CpTechnicalException;
import com.cdame.exception.SalesForceException;

public abstract class AbstractController {

    public abstract Logger getLogger();

    @ExceptionHandler(CpTechnicalException.class)
    public ResponseEntity<Map<String, String>> technicalExceptionHandler(CpTechnicalException e) {
        getLogger().warn("Handling connection exception", e);
        Map<String, String> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
    
    @ExceptionHandler(SalesForceException.class)
    public ResponseEntity<Map<String, String>> salesForceExceptionHandler(SalesForceException e) {
        getLogger().warn("Handling connection exception", e);
        Map<String, String> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}

