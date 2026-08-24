package com.example.milfoil.profile;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService extends DefaultOAuth2UserService {

    private final UserProfileRepository repository;

    public UserProfileService(UserProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) {
        OAuth2User user = super.loadUser(request);
        String provider = request.getClientRegistration().getRegistrationId();
        String providerUserId = user.getName();
        String displayName = user.getAttribute("name");
        String email = user.getAttribute("email");
        String avatarUrl = user.getAttribute("avatar_url");

        UserProfile profile = repository.findByProviderAndProviderUserId(provider, providerUserId)
                .orElseGet(() -> new UserProfile(provider, providerUserId, displayName, email, avatarUrl));
        profile.update(displayName, email, avatarUrl);
        repository.save(profile);
        return user;
    }
}