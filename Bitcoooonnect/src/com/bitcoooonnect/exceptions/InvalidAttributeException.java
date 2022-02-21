package com.bitcoooonnect.exceptions;

public class InvalidAttributeException extends RuntimeException {

    public InvalidAttributeException(){
        super();
    }

    public InvalidAttributeException(String message) {
        super(message);
    }

    public InvalidAttributeException(Throwable cause) {
        super(cause);
    }

    public InvalidAttributeException(String message, Throwable cause) {
        super(message, cause);
    }
}
