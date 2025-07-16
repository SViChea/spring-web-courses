package com.example.springrestapi.controller;

import com.example.springrestapi.dto.CourseRequest;
import com.example.springrestapi.dto.CourseResponse;
import com.example.springrestapi.model.Course;
import com.example.springrestapi.service.impl.CourseServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseServiceImpl courseService;

    @GetMapping()
    public List<CourseResponse> getAllCourses(@RequestParam(required = false) Boolean status, @RequestParam(required = false) String title) {
        return courseService.getCourses(status, title);
    }

    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable String id) {
        return courseService.getCourseByCode(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CourseRequest createCourse(@Valid @RequestBody CourseRequest courseRequest) {
        return courseService.createCourse(courseRequest);
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourseById(@PathVariable String code) {
        courseService.deleteCourseByCode(code);
    }
}
