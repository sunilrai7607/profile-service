package com.kscapser.rest.api.profileservice.repository;

import com.kscapser.rest.api.profileservice.repository.domain.CustomProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("profileRepository")
public interface IProfileRepository extends JpaRepository<CustomProfile, String> {

    Optional<CustomProfile> findByLoginUuid(final String profileId);
}
