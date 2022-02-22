package ru.rtech.education.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.rtech.education.model.User;
import ru.rtech.education.servise.UserService;

@SpringBootTest(classes = UserController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserControllerTest {

    private User user;

    @MockBean
    UserService userService;

    @Autowired
    UserController userController;

    @BeforeAll
    void init() {
        user = new User(1L, "login","ivan","ivanov");

    }

    @Test
    void When_CreateUser_Expect_ServiceCalled() {
        userController.createUser(user);
        Mockito.verify(userService).createUser(user);
    }

    @Test
    void When_GetUser_Expect_ServiceCalledList() {
        userController.getUsers();
        Mockito.verify(userService).getUsers();
    }

    @Test
    void When_GetUser_Expect_ServiceCalled() {
        Mockito.when(userService.getUser(Mockito.any())).thenReturn(user);
        Assertions.assertThat(userController.getUser(user.getId())).isEqualTo(user);
        Mockito.verify(userService, Mockito.times(1)).getUser(user.getId());
    }

    @Test
    void When_DeleteUser_Expect_ServiceCalled() {
        userController.deleteUser(user.getId());
        Mockito.verify(userService).deleteUser(user.getId());
    }
}