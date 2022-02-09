package ru.rtech.education.servise;

import ru.rtech.education.model.User;
import java.util.List;

public interface UserService {

    User getUser(Long id);

    User createUser(User user);

    List<User> getUser();

    void deleteUser(Long id);
}
