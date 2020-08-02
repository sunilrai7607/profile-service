package com.kscapser.rest.api.profileservice.model.response;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kscapser.rest.api.profileservice.repository.domain.DateOfBirth;
import com.kscapser.rest.api.profileservice.repository.domain.Location;
import com.kscapser.rest.api.profileservice.repository.domain.Login;
import com.kscapser.rest.api.profileservice.repository.domain.enums.GENDER;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"uuid"})
public class ProfileResponse implements Serializable {

    private String uuid;

    private String firstName, middleName, lastName, email;

    private String gender;

    private String street, city, state;

    private Integer postcode;

    private String phone, cell;

    private Date dob;

    private Integer age;

    private String token;

}
