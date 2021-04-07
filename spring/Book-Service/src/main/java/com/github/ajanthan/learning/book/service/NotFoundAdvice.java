package com.github.ajanthan.learning.book.service;

import com.github.ajanthan.learning.book.model.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class NotFoundAdvice {
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String,String> notFoundHandler(NotFoundException ex) {
        Map<String,String> error=new HashMap<>();
        error.put("message",ex.getMessage());
        return error;
    }
}
