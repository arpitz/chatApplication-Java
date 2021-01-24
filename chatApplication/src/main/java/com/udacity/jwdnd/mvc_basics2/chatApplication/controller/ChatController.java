package com.udacity.jwdnd.mvc_basics2.chatApplication.controller;

import com.udacity.jwdnd.mvc_basics2.chatApplication.model.ChatMessage;
import com.udacity.jwdnd.mvc_basics2.chatApplication.service.MessageListService;
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
    public String getHomePage(ChatMessage messageForm, Model model) {
        model.addAttribute("greetings", this.messageListService.getMessage(messageForm.getUserName()));
        return "home";
    }

    @PostMapping()
    public String addMessage(ChatMessage messageForm, Model model) {
        messageListService.insertMessage(messageForm);
        model.addAttribute("greetings", messageListService.getMessage(messageForm.getUserName()));
        messageForm.setMessageText("");
        return "home";
    }

}