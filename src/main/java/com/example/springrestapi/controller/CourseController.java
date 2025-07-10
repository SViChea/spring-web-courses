package com.example.springrestapi.controller;

import com.example.springrestapi.dto.CourseResponse;
import com.example.springrestapi.service.impl.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseServiceImpl courseService;

    @GetMapping()
    public List<CourseResponse> getAllCourses(@RequestParam(required = false) Boolean status, @RequestParam(required = false) String title) {
        if (status != null && title != null) {
            return courseService.filterCourseByStatusAndTitle(status, title);
        }else if (status != null){
            return courseService.filterCourseByStatus(status);
        }else{
            return courseService.getAllCourses();
        }
    }

    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable String id) {
        return courseService.getCourseByCode(id);
    }
}
