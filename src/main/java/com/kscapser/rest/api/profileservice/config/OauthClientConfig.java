package com.kscapser.rest.api.profileservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OauthClientConfig {

    @Value("${security.oauth2.client.client-id}")
    private String clientId;
    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;

    @Bean
    @ConfigurationProperties("security.oauth2.client")
    public ClientCredentialsResourceDetails oAuthDetails() {
        return new ClientCredentialsResourceDetails();
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new OAuth2RestTemplate(oAuthDetails());
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(clientId, clientSecret));
        return restTemplate;
    }
}
