package com.chatop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatop.model.Users;
import com.chatop.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<Users> getUser(final Long id) {
        return userRepository.findById(id);
    }

}
