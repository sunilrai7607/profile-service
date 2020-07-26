package com.kscapser.rest.api.profileservice.repository.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "LOGIN")
@Data
@EqualsAndHashCode(of = {"id"})
public class Login extends BaseModel implements Serializable {

    private String uuid, username, password;
    @OneToOne(mappedBy = "login")
    @JsonBackReference
    private CustomProfile customProfile;
}
