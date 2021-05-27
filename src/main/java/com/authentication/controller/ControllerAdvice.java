package com.authentication.controller;

import com.authentication.exception.EmailAlreadyExistException;
import com.authentication.exception.NoSignedUserFoundException;
import com.authentication.util.ErrorConstant;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<Map<String, Object>> handle(WebRequest request, EmailAlreadyExistException exception){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        //logs
        body.put("message", ErrorConstant.DuplicateEmail);
        return new ResponseEntity<Map<String, Object>>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSignedUserFoundException.class)
    public ResponseEntity<Map<String, Object>> handle(WebRequest request, NoSignedUserFoundException exception){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        //logs
        body.put("message", ErrorConstant.NoSignedUser);
        return new ResponseEntity<Map<String, Object>>(body, HttpStatus.NOT_FOUND);
    }
}
