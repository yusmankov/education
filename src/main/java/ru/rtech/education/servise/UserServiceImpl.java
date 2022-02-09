package ru.rtech.education.servise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rtech.education.dao.UserRepository;
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
        return userRepository.createUser(user);
    }

    @Override
    public List<User> getUser() {
        return userRepository.getUser();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
