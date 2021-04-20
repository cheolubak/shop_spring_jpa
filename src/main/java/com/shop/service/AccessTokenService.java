package com.shop.service;

import com.shop.domain.entity.AccessToken;
import com.shop.repository.AccessTokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AccessTokenService {

    private final AccessTokenRepository accessTokenRepository;
    private final long validityInSecond;

    public AccessTokenService(
            AccessTokenRepository accessTokenRepository,
            @Value("${jwt.token-validity-in-seconds}") long validityInSecond
    ) {
        this.accessTokenRepository = accessTokenRepository;
        this.validityInSecond = validityInSecond;
    }

    public Optional<AccessToken> getAuthentication(String token, String clientKey) {
        LocalDateTime now = LocalDateTime.now();
        Optional<AccessToken> accessToken = accessTokenRepository.findTopWithUserByTokenAndClientKeyAndExpiredGreaterThanOrderByExpiredDesc(
                token,
                clientKey,
                now
        );
        return accessToken;
    }

    public void refreshToken(AccessToken accessToken) {
        accessToken.setExpired(LocalDateTime.now().plusSeconds(validityInSecond));
    }
}
