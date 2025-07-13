package com.example.springrestapi.service.impl;

import com.example.springrestapi.dto.CourseRequest;
import com.example.springrestapi.dto.CourseResponse;
import com.example.springrestapi.model.Course;
import com.example.springrestapi.respository.CourseRespository;
import com.example.springrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public List<CourseResponse> getCourses(Boolean status, String title) {
        listCourses = new ArrayList<>();
        if (status != null & title != null) {
            return getAllCourses().stream()
                    .filter(course ->
                            course.status().equals(status))
                    .filter(courses -> courses.title().toLowerCase().startsWith(title)).toList();
        }else if(status != null){
            return getAllCourses().stream()
                    .filter(course ->
                            course.status().equals(status)).toList();
        }else if(title != null){
            return getAllCourses().stream()
                    .filter(courses -> courses.title().toLowerCase().startsWith(title)).toList();
        }else{
            return getAllCourses();
        }
    }

    @Override
    public CourseResponse getCourseByCode(String code) {
        return getAllCourses().stream()
                .filter(course -> course.code().equalsIgnoreCase(code))
                .findFirst().orElse(null);
    }

    @Override
    public CourseRequest createCourse(CourseRequest courseRequest) {
        boolean isExist = courseRespository.getCourses().stream()
                .anyMatch(course -> course.getCode()
                        .equalsIgnoreCase(courseRequest.code()));

        if (isExist) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Course already exists");
        }

        courseRespository.getCourses().add(Course.builder()
                        .id(UUID.randomUUID())
                        .code(courseRequest.code())
                        .title(courseRequest.title())
                        .description(courseRequest.description())
                        .price(courseRequest.price())
                        .status(false)
                .build());
        return courseRequest;
    }

    @Override
    public void deleteCourseByCode(String code) {
        boolean isExist = courseRespository.getCourses().removeIf(course->  course.getCode().equalsIgnoreCase(code));

        if (!isExist) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course doesn't exists");
        }
    }
}
