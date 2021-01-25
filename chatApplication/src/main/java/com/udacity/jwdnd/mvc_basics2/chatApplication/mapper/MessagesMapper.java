package com.udacity.jwdnd.mvc_basics2.chatApplication.mapper;

import com.udacity.jwdnd.mvc_basics2.chatApplication.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessagesMapper {

    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getAllMessages();

    @Insert("INSERT into MESSAGES (username, messagetext) " +
            "values (#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insertMessage(ChatMessage chatMessage);
}
