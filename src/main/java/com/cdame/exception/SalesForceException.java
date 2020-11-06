package com.cdame.exception;

import java.util.Arrays;

import com.cdame.domain.sf.tech.Errors;

public class SalesForceException extends Exception {

	private static final long serialVersionUID = -5125696509127450617L;

    public SalesForceException() {
        super();
    }

    public SalesForceException(String message) {
        super(message);
    }

    public SalesForceException(String message, Throwable cause) {
        super(message, cause);
    }

    public SalesForceException(Throwable cause) {
        super(cause);
    }
    
    public SalesForceException(Errors errors) {
    	this(errors.getErrorCode()+" : "+errors.getMessage());
    }
    
    public SalesForceException(Errors[] errors) {
    	this(errors[0]);
    	if (errors.length>1) {
    		this.initCause(new SalesForceException(Arrays.copyOfRange(errors, 1, errors.length)));
    	}
    }
}
