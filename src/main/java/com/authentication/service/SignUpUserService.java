package com.authentication.service;

import com.authentication.exception.EmailAlreadyExistException;
import com.authentication.exception.NoSignedUserFoundException;
import com.authentication.model.Signuser;
import com.authentication.repository.SignUpUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SignUpUserService {

    private SignUpUserRepository signUpUserRepository;

    public Signuser addUser(Signuser signuser) throws EmailAlreadyExistException {
        if(signuser == null){
            throw new EmailAlreadyExistException("Email Already Exist!!!");
        }
        return signUpUserRepository.save(signuser);
    }

    public List<Signuser> getAllUsers() throws NoSignedUserFoundException {
        List<Signuser> allSignusers = signUpUserRepository.findAll();
        if(allSignusers.isEmpty()){
            throw new NoSignedUserFoundException("No Users Yet");
        }
        return allSignusers;
    }
}
