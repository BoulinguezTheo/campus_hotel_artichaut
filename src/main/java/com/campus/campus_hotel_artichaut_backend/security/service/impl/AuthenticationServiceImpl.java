package com.campus.campus_hotel_artichaut_backend.security.service.impl;

import com.campus.campus_hotel_artichaut_backend.model.repositories.CustomerRepository;
import com.campus.campus_hotel_artichaut_backend.security.entity.User;
import com.campus.campus_hotel_artichaut_backend.model.entity.Customer;
import com.campus.campus_hotel_artichaut_backend.security.enums.Role;
import com.campus.campus_hotel_artichaut_backend.security.enums.TokenType;
import com.campus.campus_hotel_artichaut_backend.security.payload.request.AuthenticationRequest;
import com.campus.campus_hotel_artichaut_backend.security.payload.request.RegisterRequest;
import com.campus.campus_hotel_artichaut_backend.security.payload.response.AuthenticationResponse;
import com.campus.campus_hotel_artichaut_backend.security.repository.UserRepository;
import com.campus.campus_hotel_artichaut_backend.security.service.AuthenticationService;
import com.campus.campus_hotel_artichaut_backend.security.service.JwtService;
import com.campus.campus_hotel_artichaut_backend.security.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service @Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;


    @Override
    public AuthenticationResponse register(RegisterRequest request) {

        String email = request.getEmail();
        User userExist = userRepository.findByEmail(email).orElse(null);
        if (userExist != null){
            return AuthenticationResponse.builder()
                    .accessToken(null)
                    .email(request.getEmail())
                    .id(null)
                    .refreshToken(null)
                    .roles(null)
                    .tokenType(null)
                    .message("User with email "+request.getEmail()+" already exists")
                    .status("Failure")
                    .build();
        }


        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        var savedUser = userRepository.save(user);


        if(request.getRole() == Role.USER){
            var customer = Customer.builder()
                    .firstName(request.getFirstname())
                    .lastName(request.getLastname())
                    .address(request.getAddress())
                    .user(savedUser)
                    .build();

            var savedCustomer = customerRepository.save(customer);
        }



        var jwt = jwtService.generateToken(savedUser);
        var refreshToken = refreshTokenService.createRefreshToken(savedUser.getId());

        var roles = savedUser.getRole().getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .toList();

        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .email(savedUser.getEmail())
                .id(savedUser.getId())
                .refreshToken(refreshToken.getToken())
                .roles(roles)
                .tokenType( TokenType.BEARER.name())
                .message("User created")
                .status("Success")
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var roles = user.getRole().getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .toList();
        var jwt = jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(user.getId());
        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .roles(roles)
                .email(user.getEmail())
                .id(user.getId())
                .refreshToken(refreshToken.getToken())
                .tokenType( TokenType.BEARER.name())
                .message("User connected")
                .status("Success")
                .build();
    }
}
