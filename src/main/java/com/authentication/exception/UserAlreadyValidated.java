package com.authentication.exception;

public class UserAlreadyValidated extends Exception {
    public UserAlreadyValidated(String message) {
        super(message);
    }
}
