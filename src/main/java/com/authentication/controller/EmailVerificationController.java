package com.authentication.controller;

import com.authentication.exception.TokenDoesNotExistException;
import com.authentication.exception.TokenExpiredException;
import com.authentication.exception.UserAlreadyValidated;
import com.authentication.model.Signuser;
import com.authentication.service.EmailSendService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/api")
@AllArgsConstructor
public class EmailVerificationController {

    private EmailSendService emailSendService;

    @GetMapping( value = "/emailVerification/token={token}")
    public @ResponseBody String fun(@PathVariable("token") String token ) throws TokenDoesNotExistException, UserAlreadyValidated, TokenExpiredException {

        // using token get the user if exist
        Signuser user = emailSendService.getUserByToken(token);

        return "Hi Lord....Your Account Activated";
    }
}
