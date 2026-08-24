package com.example.milfoil.profile;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile> findByProviderAndProviderUserId(String provider, String providerUserId);
}