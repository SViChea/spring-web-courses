package com.example.springrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ValidationException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> fieldValidation(MethodArgumentNotValidException e){
        List<Map<String, String>> error = new ArrayList<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("name", fieldError.getField());
            errorMap.put("message", fieldError.getDefaultMessage());
            error.add(errorMap);
        }

        ErrorResponse errorResponse = new ErrorResponse(e.getBindingResult().getFieldError().getField(), e.getStatusCode().value(),  LocalDateTime.now(), error);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
