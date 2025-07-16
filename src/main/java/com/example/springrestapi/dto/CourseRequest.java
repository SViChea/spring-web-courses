package com.example.springrestapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CourseRequest(
        @NotBlank(message = "Field cannot be null")
        String code,
        @NotBlank(message = "Field cannot be null")
        String title,
        String description,
        Double price
) {
}
