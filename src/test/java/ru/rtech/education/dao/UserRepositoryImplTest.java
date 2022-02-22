package ru.rtech.education.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.rtech.education.dao.mapper.UserMapper;
import ru.rtech.education.model.User;

@SpringBootTest(classes = UserRepositoryImpl.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryImplTest {

    private User user;

    @MockBean
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @BeforeAll
    void init() {
        user = new User(1L, "login","ivan","ivanov");

    }

    @Test
    void When_GetUser_Expect_MapperCalled() {
       Mockito.when(userMapper.getUserById(user.getId())).thenReturn(user);
       Assertions.assertThat(userRepository.getUser(user.getId())).isEqualTo(user);
       Mockito.verify(userMapper).getUserById(user.getId());
    }

    @Test
    void When_GetUser_Expect_MapperCalledList() {
        userRepository.getUsers();
        Mockito.verify(userMapper).getUserByAll();
    }

    @Test
    void When_CreateUser_Expect_MapperCalled() {
        userRepository.createUser(user);
        Mockito.verify(userMapper).createUserBy(user);
    }

    @Test
    void When_DeleteUser_Expect_MapperCalled() {
        userRepository.deleteUser(user.getId());
        Mockito.verify(userMapper).deleteUserById(user.getId());
    }
}