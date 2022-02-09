package ru.rtech.education.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.rtech.education.model.User;

@RestController
public class UserController {

    @PostMapping(value = "/users")
    public User createUser(@RequestBody User user){
        return new User(1L,"login","Ivan","Ivanov");
        //test
    }
}
