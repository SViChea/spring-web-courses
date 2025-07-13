package com.example.springrestapi.service;

import com.example.springrestapi.dto.CourseRequest;
import com.example.springrestapi.dto.CourseResponse;
import com.example.springrestapi.model.Course;

import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses();
    List<CourseResponse> getCourses(Boolean status, String title);
    CourseResponse getCourseByCode(String code);
    CourseRequest createCourse(CourseRequest courseRequest);
    void deleteCourseByCode(String code);
}
