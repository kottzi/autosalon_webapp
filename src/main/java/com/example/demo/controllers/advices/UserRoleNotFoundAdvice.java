package com.example.demo.controllers.advices;

import com.example.demo.controllers.exceptions.UserRoleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserRoleNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(UserRoleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userRoleNotFoundHandler(UserRoleNotFoundException ex) {
        return ex.getMessage();
    }
}
