package com.kscapser.rest.api.profileservice.controller;

import com.kscapser.rest.api.profileservice.repository.domain.CustomProfile;
import com.kscapser.rest.api.profileservice.service.impl.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/api/v1/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CustomProfile>> getAllProfiles() {
        return ResponseEntity.ok(profileService.findAll());
    }

    @GetMapping(value = "/{profileId}")
    public ResponseEntity<CustomProfile> getAllProfiles(@PathVariable("profileId") String profileId) {
        return ResponseEntity.ok(profileService.findByProfileId(profileId));
    }


}
