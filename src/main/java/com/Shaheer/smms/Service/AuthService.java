package com.Shaheer.smms.Service;


import com.Shaheer.smms.Model.AuthUser;
import com.Shaheer.smms.Repository.AuthUserRepository;
import com.Shaheer.smms.Service.JWTService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Shaheer.smms.Dto.*;

@Service
public class AuthService {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(AuthUserRepository authUserRepository,
                       PasswordEncoder passwordEncoder,
                       JWTService jwtService,
                       AuthenticationManager authenticationManager) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponseDTO register(RegisterRequestDTO request) {
        AuthUser user = new AuthUser();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // BCrypt encryption
        user.setRole(AuthUser.Type.valueOf(request.getRole() != null ? request.getRole() : "USER"));

        authUserRepository.save(user);

        String jwtToken = jwtService.generateToken(user);
        return new AuthResponseDTO(jwtToken);
    }

    public AuthResponseDTO authenticate(AuthRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        AuthUser user = authUserRepository.findByEmail(request.getEmail());

        String jwtToken = jwtService.generateToken(user);
        return new AuthResponseDTO(jwtToken);
    }
}