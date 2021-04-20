package com.shop.config;

import com.shop.domain.entity.AccessToken;
import com.shop.domain.entity.User;
import com.shop.service.AccessTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class AccessTokenFilter extends OncePerRequestFilter {
    private Logger logger = LoggerFactory.getLogger(AccessTokenFilter.class);

    private final AccessTokenService accessTokenService;
    private static final String CLIENT_KEY = "CLIENT_KEY";

    AccessTokenFilter(AccessTokenService accessTokenService) {
        this.accessTokenService = accessTokenService;
    }

    private AccessToken isAuthentication(String token, String clientKey) {
        Optional<AccessToken> findAccessToken = accessTokenService.getAuthentication(token, clientKey);
        if (findAccessToken.isPresent()) {
            AccessToken accessToken = findAccessToken.get();
            User user = accessToken.getUser();
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            user,
                            accessToken
                    );
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(usernamePasswordAuthenticationToken);
            return accessToken;
        } else {
            return null;
        }
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String token = request.getHeader(AUTHORIZATION);
        String clientKey = request.getHeader(CLIENT_KEY);

        logger.info("token : " + token);
        logger.info("clientKey : " + clientKey);

        logger.info("isToken" + !ObjectUtils.isEmpty(token) + "isClient" + !ObjectUtils.isEmpty(clientKey));

        boolean isAuthentication = false;
        AccessToken accessToken = null;
        if (!ObjectUtils.isEmpty(token) && !ObjectUtils.isEmpty(clientKey)) {
            token = token.replace("BEARER", "").trim();
            accessToken = isAuthentication(token, clientKey);
            isAuthentication = accessToken != null;
        }
        filterChain.doFilter(request, response);
        if (isAuthentication) {
            accessTokenService.refreshToken(accessToken);
        } else {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }
}
