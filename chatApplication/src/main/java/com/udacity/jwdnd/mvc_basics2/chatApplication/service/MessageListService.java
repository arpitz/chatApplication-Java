package com.udacity.jwdnd.mvc_basics2.chatApplication.service;
import com.udacity.jwdnd.mvc_basics2.chatApplication.mapper.MessagesMapper;
import com.udacity.jwdnd.mvc_basics2.chatApplication.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MessageListService{

    private MessagesMapper messagesMapper;

    public MessageListService(MessagesMapper messagesMapper){
        this.messagesMapper = messagesMapper;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("creating message service bean");
    }

    public List<ChatMessage> getChatMessages() {
        return messagesMapper.getAllMessages();
    }

    public void insertMessage(ChatMessage chatMessage) {
        messagesMapper.insertMessage(new ChatMessage(null, chatMessage.getUsername(), chatMessage.getMessageText()));
    }
}
