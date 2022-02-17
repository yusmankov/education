package ru.rtech.education.dao.mapper;

import org.apache.ibatis.annotations.*;
import ru.rtech.education.model.User;

@Mapper
public interface UserMapper {

    //@Select("select * from user where id = #{id}")
    //User getUserById(@Param("id") Long id);

//    @Select("select * from user")
//    void getUserByAll();

    @Delete("delete from users where id = #{id}")
    void deleteUserById(@Param("id") Long id);

    @Insert("insert into users values (#{id},#{login},#{firstName},#{lastName})")
    void createUserBy(@Param("id") Long id, @Param("login") String login, @Param("firstName") String firstName, @Param("lastName") String lastName);
}
