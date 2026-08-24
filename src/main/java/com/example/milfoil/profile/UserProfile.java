package com.example.milfoil.profile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String provider;
    private String providerUserId;
    private String displayName;
    private String email;
    private String avatarUrl;
    private Instant lastLogin;

    protected UserProfile() {
    }

    public UserProfile(String provider, String providerUserId, String displayName, String email, String avatarUrl) {
        this.provider = provider;
        this.providerUserId = providerUserId;
        update(displayName, email, avatarUrl);
    }

    public void update(String displayName, String email, String avatarUrl) {
        this.displayName = displayName;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.lastLogin = Instant.now();
    }

    public String getProvider() {
        return provider;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}