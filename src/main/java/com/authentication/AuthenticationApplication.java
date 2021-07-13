package com.authentication;

import com.authentication.model.Signuser;
import com.authentication.repository.SignUpUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@AllArgsConstructor
public class AuthenticationApplication {


	private SignUpUserRepository signUpUserRepository;

	@PostConstruct
	public void fun(){
		Signuser signuser1 = new Signuser("'biswa'", "jeet", "biswajeet162@gmail.com", "123","9997455512");
		signUpUserRepository.save(signuser1);

		Signuser signuser2 = new Signuser("'deepak'", "roy", "deepak162@gmail.com", "123","7895533374");
		signUpUserRepository.save(signuser2);

		Signuser signuser3 = new Signuser("'pankaj'", "mandal", "pankaj162@gmail.com", "123","8755222201");
		signUpUserRepository.save(signuser3);

		Signuser signuser4 = new Signuser("'vidhan'", "gain", "vidhan162@gmail.com", "123","123456789");
		signUpUserRepository.save(signuser4);
	}


	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

}
