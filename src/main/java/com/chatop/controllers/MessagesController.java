package com.chatop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.model.Messages;
import com.chatop.services.MessageService;

@RestController
public class MessagesController {
    
    @Autowired
    private MessageService messageService;

    @PostMapping("/messages")
    public Messages postMessage (Messages message) {
        return messageService.postMessage(message);
    }
}
