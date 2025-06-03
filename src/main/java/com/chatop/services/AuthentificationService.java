package com.chatop.services;

import org.springframework.stereotype.Service;

import com.chatop.dto.LoginRequestDto;
import com.chatop.dto.LoginResponseDto;
import com.chatop.model.Users;
import com.chatop.repository.UserRepository;

 
@Service
public class AuthentificationService {

    private UserRepository userRepository;
    public AuthentificationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
     

    public LoginResponseDto authenticate (LoginRequestDto loginRequestDto) {
        Users user = userRepository.findByUserName(loginRequestDto.getEmail());
        return null;

    }
}
