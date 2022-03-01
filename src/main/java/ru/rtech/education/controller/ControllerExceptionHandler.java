package ru.rtech.education.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.rtech.education.exception.LoginIsTakenException;
import ru.rtech.education.model.ErrorResponse;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(LoginIsTakenException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ErrorResponse handleLoginIsTakenException(LoginIsTakenException exception) {
        return new ErrorResponse(exception.getMessage());
    }

}
