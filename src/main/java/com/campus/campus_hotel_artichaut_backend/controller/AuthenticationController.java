package com.campus.campus_hotel_artichaut_backend.controller;

import com.campus.campus_hotel_artichaut_backend.security.payload.request.AuthenticationRequest;
import com.campus.campus_hotel_artichaut_backend.security.payload.request.RefreshTokenRequest;
import com.campus.campus_hotel_artichaut_backend.security.payload.request.RegisterRequest;
import com.campus.campus_hotel_artichaut_backend.security.payload.response.AuthenticationResponse;
import com.campus.campus_hotel_artichaut_backend.security.payload.response.RefreshTokenResponse;
import com.campus.campus_hotel_artichaut_backend.security.service.AuthenticationService;
import com.campus.campus_hotel_artichaut_backend.security.service.JwtService;
import com.campus.campus_hotel_artichaut_backend.security.service.RefreshTokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final RefreshTokenService refreshTokenService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/users")
    public ResponseEntity<AuthenticationResponse> register(@Valid @RequestBody RegisterRequest request) {

        System.out.println(request.getEmail());
        System.out.println(request.getRole());
        System.out.println("ttttttt");
        AuthenticationResponse authenticationResponse = authenticationService.register(request);
        ResponseCookie jwtCookie = jwtService.generateJwtCookie(authenticationResponse.getAccessToken());
        ResponseCookie refreshTokenCookie = refreshTokenService.generateRefreshTokenCookie(authenticationResponse.getRefreshToken());
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .header(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString())
                .body(authenticationResponse);
    }

    @PostMapping("/tokens")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {

        AuthenticationResponse authenticationResponse = authenticationService.authenticate(request);
        ResponseCookie jwtCookie = jwtService.generateJwtCookie(authenticationResponse.getAccessToken());
        ResponseCookie refreshTokenCookie = refreshTokenService.generateRefreshTokenCookie(authenticationResponse.getRefreshToken());
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .header(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString())
                .body(authenticationResponse);
    }

    @PutMapping("/tokens/refresh")
    public ResponseEntity<RefreshTokenResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(refreshTokenService.generateNewToken(request));
    }

    @PostMapping("/tokens/refresh-cookie")
    public ResponseEntity<RefreshTokenResponse> refreshTokenCookie(HttpServletRequest request) {
        String refreshToken = refreshTokenService.getRefreshTokenFromCookies(request);
        RefreshTokenResponse refreshTokenResponse = refreshTokenService
                .generateNewToken(new RefreshTokenRequest(refreshToken));
        ResponseCookie NewJwtCookie = jwtService.generateJwtCookie(refreshTokenResponse.getAccessToken());
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, NewJwtCookie.toString())
                .body(refreshTokenResponse);
    }

    @GetMapping("/tokens/current")
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @DeleteMapping("/tokens")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        String refreshToken = refreshTokenService.getRefreshTokenFromCookies(request);
        if (refreshToken != null) {
            refreshTokenService.deleteByToken(refreshToken);
        }
        ResponseCookie jwtCookie = jwtService.getCleanJwtCookie();
        ResponseCookie refreshTokenCookie = refreshTokenService.getCleanRefreshTokenCookie();
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .header(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString())
                .build();
    }
}