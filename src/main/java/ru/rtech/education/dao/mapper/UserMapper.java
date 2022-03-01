package ru.rtech.education.dao.mapper;

import org.apache.ibatis.annotations.*;
import ru.rtech.education.model.User;

import javax.validation.Valid;
import java.util.List;

@Mapper
public interface UserMapper {

    @Results(id = "userResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "login", column = "login"),
            @Result(property = "firstName", column = "firstname"),
            @Result(property = "lastName", column = "lastname")
    })
    @Select("select * from users where id = #{id}")
    User getUserById(@Param("id") Long id);

    @ResultMap("userResult")
    @Select("select * from users")
    List<User> getUserByAll();

    @Delete("delete from users where id = #{id}")
    void deleteUserById(@Param("id") Long id);


    @Insert("insert into users(login,firstName,lastName) values (#{user.login},#{user.firstName},#{user.lastName})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void createUserBy (@Param("user") User user);

    @ResultMap("userResult")
    @Select("select * from users where login = #{login}")
    User getUserByLogin(@Param("login") String login);

}
