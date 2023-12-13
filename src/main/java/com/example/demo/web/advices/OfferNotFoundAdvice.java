package com.example.demo.web.advices;

import com.example.demo.web.exceptions.OfferNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class OfferNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(OfferNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String offerNotFoundHandler(OfferNotFoundException ex) {
        return ex.getMessage();
    }
}
