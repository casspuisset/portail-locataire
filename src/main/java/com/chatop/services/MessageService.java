package com.chatop.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatop.dto.MessageRequestDto;
import com.chatop.model.Messages;
import com.chatop.repository.MessagesRepository;

import lombok.Data;

@Data
@Service
public class MessageService {
    @Autowired
    private MessagesRepository messagesRepository;

    public Optional<Messages> getMessage(final Long id) {
        return messagesRepository.findById(id);
    }

    public Iterable<Messages> getMessages() {
        return messagesRepository.findAll();
    }

    public Messages postMessage(MessageRequestDto message) {
        Messages newMessage = new Messages();

        newMessage.setUserId(message.getUser_id());
        newMessage.setRentalId(message.getRental_id());
        newMessage.setMessage(message.getMessage());
        newMessage.setCreatedAt(LocalDateTime.now());
        newMessage.setUpdatedAt(LocalDateTime.now());
        return messagesRepository.save(newMessage);
    }
}
