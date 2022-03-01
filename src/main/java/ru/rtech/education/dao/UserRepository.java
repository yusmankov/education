package ru.rtech.education.dao;

import ru.rtech.education.model.User;
import java.util.List;


public interface UserRepository {

    List<User> getUsers();

    User getUserByLogin(String login);

    User getUser(Long id);

    void createUser(User user);

    void deleteUser(Long id);

}
