package com.authentication.controller;

import com.authentication.exception.NoSignedUserFoundException;
import com.authentication.model.Signuser;
import com.authentication.service.SignUpUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/api")
@AllArgsConstructor
public class SignUpUserController {

    private SignUpUserService signUpUserService;

    @GetMapping( value = "/hi")
    public @ResponseBody String fun(){
        return "Hello Lord";
    }

    @GetMapping( value = "/getUsers")
    public ResponseEntity<List<Signuser>> getAllSignedUsers() throws NoSignedUserFoundException {
        List<Signuser> allSignusers = signUpUserService.getAllUsers();
        return ResponseEntity.status(HttpStatus.CREATED).body(allSignusers);
    }

    @PostMapping(value = "/signUp")
    public Boolean signUpUser(@RequestBody Signuser signuser) throws Exception {
        return signUpUserService.addUser(signuser);
        //return buildResponse(signUpSignuser);
    }



    private ResponseEntity<Signuser> buildResponse(Signuser source) {
        return ResponseEntity.status(HttpStatus.CREATED).body(source);
    }


}
