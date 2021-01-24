package com.udacity.jwdnd.mvc_basics2.chatApplication.mapper;

import com.udacity.jwdnd.mvc_basics2.chatApplication.model.ChatMessage;
import com.udacity.jwdnd.mvc_basics2.chatApplication.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessagesMapper {

    @Select("SELECT * from MESSAGES where username = #{username}")
    ChatMessage getMessage(String username);

    @Insert("INSERT into MESSAGES (username, messagetext) " +
            "values (#{userName}, #{message})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int insertMessage(String userName, String message);
}
