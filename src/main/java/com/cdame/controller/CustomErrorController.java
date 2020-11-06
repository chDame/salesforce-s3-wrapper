package com.cdame.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.cdame.domain.technical.ErrorPageModel;

public class CustomErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = "/error")
    ErrorPageModel error(WebRequest request, HttpServletResponse response) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by
        // Spring.
        // Here we just define response body.
        return new ErrorPageModel(response.getStatus(), getErrorAttributes(request, false));
    }

    private Map<String, Object> getErrorAttributes(WebRequest request, boolean includeStackTrace) {
        return errorAttributes.getErrorAttributes(request, includeStackTrace);
    }
}
