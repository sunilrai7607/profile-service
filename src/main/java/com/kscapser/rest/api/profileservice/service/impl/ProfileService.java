package com.kscapser.rest.api.profileservice.service.impl;

import com.kscapser.rest.api.profileservice.repository.IProfileRepository;
import com.kscapser.rest.api.profileservice.repository.domain.CustomProfile;
import com.kscapser.rest.api.profileservice.service.IProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProfileService implements IProfileService {

    private final IProfileRepository profileRepository;

    @Autowired
    public ProfileService(IProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    /**
     * Method to get all profiles
     *
     * @return
     */
    @Override
    public List<CustomProfile> findAll() {
        return profileRepository.findAll();
    }

    /**
     * Method to find the profile by profileId
     *
     * @param profileId
     * @return
     */
    @Override
    public CustomProfile findByProfileId(final String profileId) {
        return profileRepository.findByLoginUuid(profileId).orElseThrow(() -> new UsernameNotFoundException("Invalid profileId " + profileId));
    }
}
