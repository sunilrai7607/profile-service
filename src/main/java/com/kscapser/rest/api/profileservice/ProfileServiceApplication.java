package com.kscapser.rest.api.profileservice;

import com.kscapser.rest.api.profileservice.model.request.LoginRequest;
import com.kscapser.rest.api.profileservice.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableJpaRepositories
@EnableResourceServer
public class ProfileServiceApplication implements CommandLineRunner {

    @Autowired
    private IProfileService profileService;


    public static void main(String[] args) {
        SpringApplication.run(ProfileServiceApplication.class, args);
    }


    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        LoginRequest request = new LoginRequest();
        request.setPassword("test123");
        request.setUserId("sunil1976");
        //profileService.userSignIn(request, response);
    }
}
