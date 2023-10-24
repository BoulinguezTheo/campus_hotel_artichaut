package com.campus.campus_hotel_artichaut_backend.service;

import com.campus.campus_hotel_artichaut_backend.payload.request.AuthenticationRequest;
import com.campus.campus_hotel_artichaut_backend.payload.request.RegisterRequest;
import com.campus.campus_hotel_artichaut_backend.payload.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
