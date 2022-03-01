package ru.rtech.education.exception;


public class LoginIsTakenException extends RuntimeException {

    public LoginIsTakenException(String login) {
        super(String.format("User with login = %s already exists.", login));
    }

}
