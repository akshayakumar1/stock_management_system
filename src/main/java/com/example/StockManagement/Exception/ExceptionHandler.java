package com.example.StockManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String,String> error=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((err)->error.put(err.getField(), err.getDefaultMessage()));
        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(StockNotFoundException.class)
    public Map<String, String> stockNotExist(StockNotFoundException ex){
        Map<String,String> error=new HashMap<>();
        error.put(String.valueOf(ex.getId()),ex.getMessage());
        return error;
    }
}
