package com.udacity.jwdnd.mvc_basics2.chatApplication.model;

public class ChatMessage {

    private String userName;
    private String messageText;

    public ChatMessage(String userName, String messageText) {
        this.userName = userName;
        this.messageText = messageText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
