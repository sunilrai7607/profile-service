package com.kscapser.rest.api.profileservice.service;

import com.kscapser.rest.api.profileservice.model.request.LoginRequest;
import com.kscapser.rest.api.profileservice.model.response.ProfileResponse;
import com.kscapser.rest.api.profileservice.repository.domain.CustomProfile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IProfileService {
    /**
     * Method to get all profiles
     *
     * @return
     */
    List<CustomProfile> findAll();

    /**
     * Method to find profile by profileId
     *
     * @param profileId
     * @return
     */
    CustomProfile findByProfileId(String profileId);

    /**
     * Method to sign user
     *
     * @param loginRequest
     * @param response
     * @return
     */
    ProfileResponse userSignIn(LoginRequest loginRequest, HttpServletResponse response);
}
