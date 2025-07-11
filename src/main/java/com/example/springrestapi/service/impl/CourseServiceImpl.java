package com.example.springrestapi.service.impl;

import com.example.springrestapi.dto.CourseRequest;
import com.example.springrestapi.dto.CourseResponse;
import com.example.springrestapi.model.Course;
import com.example.springrestapi.respository.CourseRespository;
import com.example.springrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRespository courseRespository;
    private List<CourseResponse> listCourses;

    @Override
    public List<CourseResponse> getAllCourses() {
        listCourses = new ArrayList<>();
        courseRespository.getCourses().stream()
                .map(course -> listCourses.add(CourseResponse.builder()
                .code(course.getCode())
                .title(course.getTitle())
                .description(course.getDescription())
                .price(course.getPrice())
                .status(course.getStatus())
                .build()
        )).toList();

        return listCourses;
    }

    @Override
    public List<CourseResponse> filterCourseByStatus(Boolean status) {
        return getAllCourses().stream()
                .filter(course ->
                        course.status().equals(status)).toList();
    }

    @Override
    public List<CourseResponse> filterCourseByStatusAndTitle(Boolean status, String title) {
        return getAllCourses().stream()
                .filter(course ->
                        course.status().equals(status))
                .filter(courses -> courses.title().toLowerCase().startsWith(title)).toList();
    }

    @Override
    public CourseResponse getCourseByCode(String code) {
        return getAllCourses().stream()
                .filter(course -> course.code().equalsIgnoreCase(code))
                .findFirst().orElse(null);
    }

    @Override
    public CourseRequest createCourse(CourseRequest courseRequest) {
        courseRespository.createCourse(Course.builder()
                        .id(UUID.randomUUID())
                        .code("b-11")
                        .title(courseRequest.title())
                        .description(courseRequest.description())
                        .price(courseRequest.price())
                        .status(false)
                .build());
        return courseRequest;
    }
}
