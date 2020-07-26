package com.kscapser.rest.api.profileservice.repository.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kscapser.rest.api.profileservice.repository.domain.enums.GENDER;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PROFILE")
@Data
@EqualsAndHashCode(of = {"id"})
public class CustomProfile extends BaseModel implements Serializable {

    private static final long serialVersionUID = 7239909656755589054L;

    private String firstName, middleName, lastName, email;

    @Enumerated(EnumType.STRING)
    private GENDER gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @JsonManagedReference
    private Location location;

    private String phone, cell;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dateOfBirth_id", referencedColumnName = "id")
    @JsonManagedReference
    private DateOfBirth dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    @JsonManagedReference
    private Login login;
}
