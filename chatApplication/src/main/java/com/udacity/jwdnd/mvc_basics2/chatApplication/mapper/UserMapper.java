package com.udacity.jwdnd.mvc_basics2.chatApplication.mapper;

import com.udacity.jwdnd.mvc_basics2.chatApplication.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * from users where username = #{username}")
    User getUser(String username);

    @Insert("INSERT into users (username, salt, password, firstname, lastname) " +
            "values (#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insertUser(User user);
}
