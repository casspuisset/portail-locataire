package com.chatop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.dto.LoginRequestDto;
import com.chatop.dto.LoginResponseDto;
import com.chatop.dto.RegisterRequestDto;
import com.chatop.model.Users;
import com.chatop.repository.UserRepository;
import com.chatop.services.AuthentificationService;
import com.chatop.services.JWTService;
import com.chatop.services.UserService;

import lombok.var;

@RestController
@RequestMapping("/api/auth")
public class AuthentificationController {

    private final BCryptPasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final UserService userService;

    private AuthentificationService authentificationService;

    public AuthentificationController(JWTService jwtService, AuthentificationService authentificationService,
            UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, UserService userService) {
        this.authentificationService = authentificationService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequestDto user) {
        userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> getToken(@RequestBody LoginRequestDto loginRequestDto) {

        var loginResponseDto = authentificationService.authenticate(loginRequestDto);
        return ResponseEntity.ok(loginResponseDto);
    }

}
/**
 * /auth/register PostMapping
 * /auth/login PostMapping
 * /auth/me GetMapping
 * 
 */