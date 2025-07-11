package com.example.springrestapi.service;

import com.example.springrestapi.dto.CourseRequest;
import com.example.springrestapi.dto.CourseResponse;
import com.example.springrestapi.model.Course;

import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses();
    List<CourseResponse> filterCourseByStatus(Boolean status);
    List<CourseResponse> filterCourseByStatusAndTitle(Boolean status, String title);
    CourseResponse getCourseByCode(String code);
    CourseRequest createCourse(CourseRequest courseRequest);
}
