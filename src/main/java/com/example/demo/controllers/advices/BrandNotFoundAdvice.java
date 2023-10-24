package com.example.demo.controllers.advices;

import com.example.demo.controllers.exceptions.BrandNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BrandNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(BrandNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String brandNotFoundHandler(BrandNotFoundException ex) {
        return ex.getMessage();
    }
}
