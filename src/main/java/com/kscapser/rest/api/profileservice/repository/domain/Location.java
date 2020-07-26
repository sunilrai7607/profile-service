package com.kscapser.rest.api.profileservice.repository.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "LOCATION")
@Data
@EqualsAndHashCode(of = {"id"})
public class Location extends BaseModel implements Serializable {

    private String street, city, state;
    private Integer postcode;
    @OneToOne(mappedBy = "location")
    @JsonBackReference
    private CustomProfile customProfile;

}
