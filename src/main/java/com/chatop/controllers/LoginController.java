package com.chatop.controllers;


import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.dto.LoginRequestDto;
import com.chatop.dto.LoginResponseDto;
import com.chatop.services.AuthentificationService;
import com.chatop.services.JWTService;

import lombok.var;


@RestController
public class LoginController {

    // private JWTService jwtService;
    private AuthentificationService authentificationService;

    public LoginController(JWTService jwtService, AuthentificationService authentificationService) {
        // this.jwtService = jwtService;
this.authentificationService = authentificationService;
    }
    
    // @PostMapping("auth/register")
    // //route d'enregistrement

    @PostMapping("auth/login")
    public ResponseEntity<LoginResponseDto> getToken(@RequestBody LoginRequestDto loginRequestDto) {
        var loginResponseDto = authentificationService.authenticate(loginRequestDto);
        return ResponseEntity.ok(loginResponseDto);
    }

    // @GetMapping("auth/me")
    
}
/**
 * /auth/register PostMapping
 * /auth/login PostMapping
 * /auth/me GetMapping
 * 
 */