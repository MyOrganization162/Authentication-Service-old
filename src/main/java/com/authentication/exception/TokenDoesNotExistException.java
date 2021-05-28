package com.authentication.exception;

public class TokenDoesNotExistException extends Exception {
    public TokenDoesNotExistException(String message) {
        super(message);
    }
}
