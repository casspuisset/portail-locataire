package com.chatop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.dto.MessageRequestDto;
import com.chatop.model.Messages;
import com.chatop.services.MessageService;

@RestController
public class MessagesController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/messages")
    public Messages postMessage(MessageRequestDto message) {
        return messageService.postMessage(message);
    }
}
