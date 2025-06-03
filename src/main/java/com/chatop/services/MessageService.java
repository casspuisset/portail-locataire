package com.chatop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chatop.model.Messages;
import com.chatop.repository.MessagesRepository;

import lombok.Data;

@Data
@Service
public class MessageService {
    @Autowired
    private MessagesRepository messagesRepository;

    public Messages postMessage(Messages message){
        Messages newMessage = messagesRepository.save(message);
        return newMessage;
    }
}
