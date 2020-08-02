package com.kscapser.rest.api.profileservice.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class LoginRequest implements Serializable {


    private static final long serialVersionUID = 1091683607881682510L;
    @NotNull
    @NotEmpty
    private String userId;
    @NotNull
    @NotEmpty
    private String password;
}
