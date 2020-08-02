package com.kscapser.rest.api.profileservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kscapser.rest.api.profileservice.model.client.TokenResponse;
import com.kscapser.rest.api.profileservice.model.mapper.ProfileMapper;
import com.kscapser.rest.api.profileservice.model.request.LoginRequest;
import com.kscapser.rest.api.profileservice.model.response.ProfileResponse;
import com.kscapser.rest.api.profileservice.repository.IProfileRepository;
import com.kscapser.rest.api.profileservice.repository.domain.CustomProfile;
import com.kscapser.rest.api.profileservice.service.IProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
@Slf4j
public class ProfileService implements IProfileService {

    private final IProfileRepository profileRepository;
    private final RestTemplate restTemplate;
    @Value("${security.oauth2.client.client-id}")
    private String clientId;
    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;


    @Autowired
    public ProfileService(IProfileRepository profileRepository, RestTemplate restTemplate) {
        this.profileRepository = profileRepository;
        this.restTemplate = restTemplate;
    }

    /**
     * Method to get all profiles
     *
     * @return
     */
    @Override
    public List<CustomProfile> findAll() {
        return profileRepository.findAll();
    }

    /**
     * Method to find the profile by profileId
     *
     * @param profileId
     * @return
     */
    @Override
    public CustomProfile findByProfileId(final String profileId) {
        return profileRepository.findByLoginUuid(profileId).orElseThrow(() -> new UsernameNotFoundException("Invalid profileId " + profileId));
    }

    /**
     * Method to sign user
     *
     * @param loginRequest
     * @param response
     * @return
     */
    @Override
    public ProfileResponse userSignIn(LoginRequest loginRequest, HttpServletResponse response) {
        log.info("Login Information {} ", loginRequest);
        CustomProfile customerProfile = profileRepository.findByLoginUsernameAndLoginPassword(loginRequest.getUserId(), loginRequest.getPassword())
                .orElseThrow(() -> new UsernameNotFoundException("Invalid user "));
        TokenResponse tokenResponse = authorizeRequest(loginRequest);
        log.info("tokenResponse {} ", tokenResponse);
        StringBuffer sb = new StringBuffer(tokenResponse.getTokenType());
        sb.append(" ");
        sb.append(tokenResponse.getAccessToken());
        response.addHeader("x-token",sb.toString());
        ProfileResponse profileResponse = ProfileMapper.INSTANCE.profileMapper(customerProfile);
        profileResponse.setToken(sb.toString());
        return profileResponse;
    }

    private TokenResponse authorizeRequest(LoginRequest loginRequest) {
        String url = "http://localhost:8080/oauth/token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(clientId, clientSecret);
        StringBuffer sb = new StringBuffer(url);
        sb.append("?grant_type=password&username=");
        sb.append(loginRequest.getUserId());
        sb.append("&password=");
        sb.append(loginRequest.getPassword());
        HttpEntity<String> requestEntity = new HttpEntity<>("Headers", headers);
        ResponseEntity<Object> response = restTemplate.exchange(sb.toString(), HttpMethod.POST, requestEntity, Object.class);
        log.info("Resposne statusCode: {} ", response.getStatusCode());
        log.info("Resposne headers: {} ", response.getHeaders());

        return new ObjectMapper().convertValue(response.getBody(), TokenResponse.class);

    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
