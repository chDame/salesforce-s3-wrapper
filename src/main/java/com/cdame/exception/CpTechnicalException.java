package com.cdame.exception;

public class CpTechnicalException extends Exception {

    private static final long serialVersionUID = 6086467872968062697L;

    public CpTechnicalException() {
        super();
    }

    public CpTechnicalException(String message) {
        super(message);
    }

    public CpTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public CpTechnicalException(Throwable cause) {
        super(cause);
    }
}
