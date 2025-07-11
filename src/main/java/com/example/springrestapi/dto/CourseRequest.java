package com.example.springrestapi.dto;

public record CourseRequest(
        String title,
        String description,
        Double price
) {
}
