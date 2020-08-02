package com.kscapser.rest.api.profileservice.model.mapper;

import com.kscapser.rest.api.profileservice.model.response.ProfileResponse;
import com.kscapser.rest.api.profileservice.repository.domain.CustomProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    @Mapping(source = "login.uuid", target = "uuid")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = " middleName", target = "middleName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "location.street", target = "street")
    @Mapping(source = "location.city", target = "city")
    @Mapping(source = "location.state", target = "state")
    @Mapping(source = "location.postcode", target = "postcode")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "cell", target = "cell")
    @Mapping(source = "dateOfBirth.dob", target = "dob")
    @Mapping(source = "dateOfBirth.age", target = "age")
    ProfileResponse profileMapper(CustomProfile customProfile);

}
