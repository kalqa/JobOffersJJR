package com.junioroffers.infrastructure.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.junioroffers.infrastructure.loginandregister.controller.dto.JwtResponseDto;
import com.junioroffers.infrastructure.loginandregister.controller.dto.TokenRequestDto;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class JwtAuthenticatorFacade {

    private final AuthenticationManager authenticationManager;
    private final Clock clock;
    private final JwtConfigurationProperties properties;

    public JwtResponseDto authenticateAndGenerateToken(TokenRequestDto loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        User user = (User) authenticate.getPrincipal();
        String token = createToken(user);
        String username = user.getUsername();
        return JwtResponseDto.builder()
                .token(token)
                .username(username)
                .build();
    }

    private String createToken(User user) {
        String secretKey = properties.secret();
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        Instant now = LocalDateTime.now(clock).toInstant(ZoneOffset.UTC);
        Instant expiresAt = now.plus(Duration.ofDays(properties.expirationDays()));
        String issuer = properties.issuer();
        return JWT.create()
                .withSubject(user.getUsername())
                .withIssuedAt(now)
                .withExpiresAt(expiresAt)
                .withIssuer(issuer)
                .sign(algorithm);
    }

}
