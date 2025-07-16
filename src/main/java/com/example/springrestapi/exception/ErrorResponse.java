package com.example.springrestapi.exception;

import java.time.LocalDateTime;

public record ErrorResponse<T>(
        String message,
        Integer status,
        LocalDateTime timestamp,
        T details
) {
}
