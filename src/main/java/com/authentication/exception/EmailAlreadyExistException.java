package com.authentication.exception;

public class EmailAlreadyExistException extends Exception {
    public EmailAlreadyExistException(String message) {
        super(message);
    }
}
