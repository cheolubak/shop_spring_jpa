package com.shop.repository;

import com.shop.domain.entity.AccessToken;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessToken, String> {
    @EntityGraph(attributePaths = "user")
    Optional<AccessToken> findTopWithUserByTokenAndClientKeyAndExpiredGreaterThanOrderByExpiredDesc(
            String token,
            String clientKey,
            LocalDateTime expired
    );
}
