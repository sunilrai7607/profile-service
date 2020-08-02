package com.kscapser.rest.api.profileservice.controller;

import com.kscapser.rest.api.profileservice.model.request.LoginRequest;
import com.kscapser.rest.api.profileservice.model.response.ProfileResponse;
import com.kscapser.rest.api.profileservice.repository.domain.CustomProfile;
import com.kscapser.rest.api.profileservice.service.impl.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "rest/api/v1/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Slf4j
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

    @PostMapping(value = "/signIn", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileResponse> userSign(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        log.info("LoginRequest : {} ", loginRequest);
        return ResponseEntity.ok(profileService.userSignIn(loginRequest, response));
    }


}
