package com.udacity.jwdnd.mvc_basics2.chatApplication.model;

public class ChatMessage {

    private Integer messageId;
    private String username;
    private String messageText;

    public ChatMessage() {
    }

    public ChatMessage(Integer messageId, String username, String messageText) {
        this.messageId = messageId;
        this.username = username;
        this.messageText = messageText;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
