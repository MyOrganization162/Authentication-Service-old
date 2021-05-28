package com.authentication.service;

import com.authentication.exception.EmailAlreadyExistException;
import com.authentication.exception.NoSignedUserFoundException;
import com.authentication.model.Signuser;
import com.authentication.repository.SignUpUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class SignUpUserService {

    private SignUpUserRepository signUpUserRepository;
    private EmailSendService emailSendService;

    public Boolean addUser(Signuser signuser) throws EmailAlreadyExistException, MessagingException {

        Signuser emailExist = signUpUserRepository.findByEmail(signuser.getEmail()).orElse(null);
        if(emailExist != null){
            throw new EmailAlreadyExistException("Email Already Exist!!!");
        }

        // Email Is New. So create a Token and send him a verification Link to his mail Id
        String token = UUID.randomUUID().toString();
        signuser.setToken(token);
        signuser.setCreationtime(LocalDateTime.now().plusSeconds(30)); // expires in 30 seconds

        // NO NEED AT PRODUCTION TIME
        signuser.setEnabled(false);

        // Call Service of Email Send  //-----> http://localhost:8100/emailVerification/token=
        Boolean emailSuccessfullySent = emailSendService.sendVerificationLink(signuser.getFirstName(), signuser.getEmail(), token);

        // If No error while sending Email Verifucation
        signUpUserRepository.save(signuser);

        return emailSuccessfullySent;
    }

    public List<Signuser> getAllUsers() throws NoSignedUserFoundException {
        List<Signuser> allSignusers = signUpUserRepository.findAll();
        if(allSignusers.isEmpty()){
            throw new NoSignedUserFoundException("No Users Yet");
        }
        return allSignusers;
    }
}
