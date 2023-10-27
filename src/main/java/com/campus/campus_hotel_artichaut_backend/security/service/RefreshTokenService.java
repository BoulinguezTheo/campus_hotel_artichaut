package com.campus.campus_hotel_artichaut_backend.security.service;

import com.campus.campus_hotel_artichaut_backend.security.entity.RefreshToken;
import com.campus.campus_hotel_artichaut_backend.security.payload.request.RefreshTokenRequest;
import com.campus.campus_hotel_artichaut_backend.security.payload.response.RefreshTokenResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseCookie;

import java.util.Optional;

public interface RefreshTokenService {

    RefreshToken createRefreshToken(Long userId);
    RefreshToken verifyExpiration(RefreshToken token);
    Optional<RefreshToken> findByToken(String token);
    RefreshTokenResponse generateNewToken(RefreshTokenRequest request);
    ResponseCookie generateRefreshTokenCookie(String token);
    String getRefreshTokenFromCookies(HttpServletRequest request);
    void deleteByToken(String token);
    ResponseCookie getCleanRefreshTokenCookie();
}
