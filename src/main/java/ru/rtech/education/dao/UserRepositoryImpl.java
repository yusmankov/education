package ru.rtech.education.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.rtech.education.dao.mapper.UserMapper;
import ru.rtech.education.model.User;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.getUserByAll();
    }

    @Override
    public User getUser(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return userMapper.getUserByLogin(login);
    }

    @Override
    public void createUser(User user) {
        userMapper.createUserBy(user);
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteUserById(id);
    }

}
