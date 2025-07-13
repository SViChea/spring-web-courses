package com.example.springrestapi.dto;

import lombok.Builder;

@Builder
public record CourseRequest(
        String code,
        String title,
        String description,
        Double price
) {
}
