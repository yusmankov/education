package ru.rtech.education.servise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rtech.education.dao.UserRepository;
import ru.rtech.education.exception.LoginIsTakenException;
import ru.rtech.education.model.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.getUser(id);
    }

    @Override
    public User createUser(User user) {
        if (userRepository.getUserByLogin(user.getLogin()) != null) {
            throw new LoginIsTakenException(user.getLogin());
        }
        userRepository.createUser(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
