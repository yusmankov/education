package ru.rtech.education.dao;

import ru.rtech.education.model.User;
import java.util.List;


public interface UserRepository {

    List<User> getUser();

    User getUser(Long id);

    User createUser(User user);

    void deleteUser(Long id);

}
