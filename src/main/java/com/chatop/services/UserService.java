package com.chatop.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.chatop.dto.RegisterRequestDto;
import com.chatop.model.Users;
import com.chatop.repository.UserRepository;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;

    public User getUserByUserEmail(String email) {
        Users user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Utilisateur non-trouvé : " + email);
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), null);
    }

    public void register(RegisterRequestDto registerRequestDto) {
        Users user = userRepository.findByEmail(registerRequestDto.getEmail());
        if (user != null) {
            log.warn("L'utilisateur existe déjà avec ce mail");
        } else {
            String passwordEncoded = passwordEncoder.encode(registerRequestDto.getPassword());
            user.setEmail(registerRequestDto.getEmail());
            user.setPassword(passwordEncoded);
            user.setName(registerRequestDto.getName());
            user.setCreatedAt(LocalDateTime.now());
            user.setUpdatedAt(LocalDateTime.now());
            userRepository.save(user);
        }
    }

    public Optional<Users> getUserById(Long id) {
        Optional<Users> user = userRepository.findById(id);
        return user;
    }

    public Optional<Users> getUserByName(Long id) {
        Optional<Users> user = userRepository.findById(id);
        return user;
    }
}
