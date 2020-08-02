package com.kscapser.rest.api.profileservice.model.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse implements Serializable {


    private static final long serialVersionUID = 7450148876158818580L;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("expires_in")
    private Integer expiresIn;
    @JsonProperty("scope")
    private String scope;
    @JsonProperty("jti")
    private String jti;
}
