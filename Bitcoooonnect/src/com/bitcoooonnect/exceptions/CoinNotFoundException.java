package com.bitcoooonnect.exceptions;

public class CoinNotFoundException extends RuntimeException {

    public CoinNotFoundException(){
        super();
    }

    public CoinNotFoundException(String message) {
        super(message);
    }

    public CoinNotFoundException(Throwable cause) {
        super(cause);
    }

    public CoinNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
