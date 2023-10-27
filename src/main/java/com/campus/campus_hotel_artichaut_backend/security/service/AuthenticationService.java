package com.campus.campus_hotel_artichaut_backend.security.service;

import com.campus.campus_hotel_artichaut_backend.security.payload.request.AuthenticationRequest;
import com.campus.campus_hotel_artichaut_backend.security.payload.request.RegisterRequest;
import com.campus.campus_hotel_artichaut_backend.security.payload.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
