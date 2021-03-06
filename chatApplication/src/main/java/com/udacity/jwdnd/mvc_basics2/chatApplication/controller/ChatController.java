package com.udacity.jwdnd.mvc_basics2.chatApplication.controller;

import com.udacity.jwdnd.mvc_basics2.chatApplication.model.ChatMessage;
import com.udacity.jwdnd.mvc_basics2.chatApplication.service.MessageListService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageListService messageListService;

    public ChatController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping()
    public String getHomePage(@ModelAttribute("messageForm") ChatMessage messageForm, Model model) {
        model.addAttribute("greetings", this.messageListService.getChatMessages());
        return "chat";
    }

    @PostMapping()
    public String addMessage(Authentication authentication, @ModelAttribute("messageForm") ChatMessage messageForm, Model model) {
        messageForm.setUsername(authentication.getName());
        messageListService.insertMessage(messageForm);
        model.addAttribute("greetings", messageListService.getChatMessages());
        messageForm.setMessageText("");
        return "chat";
    }

}