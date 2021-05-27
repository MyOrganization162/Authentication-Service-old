package com.authentication.exception;

public class NoSignedUserFoundException extends Throwable {
    public NoSignedUserFoundException(String message) {
        super(message);
    }
}
