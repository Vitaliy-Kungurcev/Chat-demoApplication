package com.example.intechdemoapplication.service;

import com.example.intechdemoapplication.entity.Message;
import com.example.intechdemoapplication.entity.User;
import com.example.intechdemoapplication.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public void saveMessage(Message message, User user) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        message.setUserName(user.getUsername());
        message.setDateTime(dateTime);
        messageRepository.save(message);
    }

    public List<Message> allMessage() {
        List<Message> allMessage = messageRepository.findAll();
        return allMessage;
    }
}
