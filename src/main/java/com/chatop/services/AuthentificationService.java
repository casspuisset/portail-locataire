package com.chatop.services;

import org.springframework.stereotype.Service;

import com.chatop.dto.LoginRequestDto;
import com.chatop.dto.LoginResponseDto;
import com.chatop.model.Users;
import com.chatop.repository.UserRepository;

@Service
public class AuthentificationService {

    private UserRepository userRepository;
    private JWTService jwtService;

    public AuthentificationService(JWTService jwtService, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;

    }

    public LoginResponseDto authenticate(LoginRequestDto loginRequestDto) {
        Users user = userRepository.findByUserName(loginRequestDto.getEmail());
        if (user != null) {
            String token = jwtService.generateToken(loginRequestDto.getEmail());
            return new LoginResponseDto(token);
        } else {
            return null;
        }
    }
}
