package com.kscapser.rest.api.profileservice.service;

import com.kscapser.rest.api.profileservice.repository.domain.CustomProfile;

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
}
