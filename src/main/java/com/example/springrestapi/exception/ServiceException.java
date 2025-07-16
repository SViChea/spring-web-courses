package com.example.springrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ServiceException {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(ResponseStatusException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getReason(), e.getStatusCode().value(),  LocalDateTime.now(), e.getReason());
        return ResponseEntity.status(errorResponse.status()).body(errorResponse);
    }
}
