package com.kscapser.rest.api.profileservice.repository.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DATEOFBIRTH")
@Data
@EqualsAndHashCode(of = {"id"})
public class DateOfBirth extends BaseModel implements Serializable {

    private Date dob;
    private Integer age;
    @OneToOne(mappedBy = "dateOfBirth")
    @JsonBackReference
    private CustomProfile customProfile;
}
