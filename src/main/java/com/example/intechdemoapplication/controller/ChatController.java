package com.example.intechdemoapplication.controller;

import com.example.intechdemoapplication.entity.Message;
import com.example.intechdemoapplication.entity.User;
import com.example.intechdemoapplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    MessageService messageService;

    @GetMapping({"/","/chat"})
    public String showChat(Model model) {
        List<Message> allMessage = messageService.allMessage();
        model.addAttribute("allMessage", allMessage);
        model.addAttribute("newMessage", new Message());
        return "chat";
    }

    @PostMapping("/addMessage")
    public String addMessage(@AuthenticationPrincipal User user,
                             @ModelAttribute("newMessage") @Valid Message message, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/chat";
        }
        messageService.saveMessage(message,user);
        return "redirect:/chat";
    }
}
