package com.cdame.exception;

public class CpSecurityException extends Exception {

    private static final long serialVersionUID = 6086467872968062697L;

    public CpSecurityException() {
        super();
    }

    public CpSecurityException(String message) {
        super(message);
    }

    public CpSecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public CpSecurityException(Throwable cause) {
        super(cause);
    }
}
