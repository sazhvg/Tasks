package com.ua.sazhyn.volodymyr.springtask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DataExceptionHandler {

    @ExceptionHandler(DataRegistrationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public  void handlerGuestException(){
    }
}
