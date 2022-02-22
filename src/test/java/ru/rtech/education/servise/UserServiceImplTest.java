package ru.rtech.education.servise;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.rtech.education.dao.UserRepository;
import ru.rtech.education.model.User;

import java.util.List;

@SpringBootTest(classes = UserServiceImpl.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceImplTest {

    private User user;

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @BeforeAll
    void init() {
        user = new User(1L, "login","ivan","ivanov");

    }

    @Test
    void When_GetUser_Expect_RepositoryCalled() {
        Mockito.when(userRepository.getUser(Mockito.any())).thenReturn(user);
        Assertions.assertThat(userService.getUser(user.getId())).isEqualTo(user);
        Mockito.verify(userRepository, Mockito.times(1)).getUser(user.getId());
    }


    @Test
    void When_DeleteUser_Expect_RepositoryCalled() {
        userService.deleteUser(user.getId());
        Mockito.verify(userRepository).deleteUser(user.getId());
    }

    @Test
    void When_GetUser_Expect_RepositoryCalledList() {
        List<User> users = List.of(user);
        Mockito.when(userRepository.getUsers()).thenReturn(users);
        Assertions.assertThat(userRepository.getUsers()).isEqualTo(users);
        Mockito.verify(userRepository).getUsers();

    }

    @Test
    void When_CreateUser_Expect_RepositoryCalled() {
        userService.createUser(user);
        Mockito.verify(userRepository).createUser(user);
    }
}