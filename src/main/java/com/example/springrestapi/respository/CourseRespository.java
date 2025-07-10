package com.example.springrestapi.respository;

import com.example.springrestapi.dto.CourseResponse;
import com.example.springrestapi.model.Course;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Getter
@Setter
public class CourseRespository {
    private List<Course> courses;

    public CourseRespository() {
        courses = new ArrayList<>();
        List<CourseResponse> courseResponses = new ArrayList<>();
        courses.add(Course.builder()
                .id(UUID.randomUUID())
                .code("b-01")
                .title("Spring REST API")
                .description("Spring REST API")
                .price(100.00)
                .status(true)
                .build());

        courses.add(Course.builder()
                .id(UUID.randomUUID())
                .code("b-02")
                .title("Java Fundamentals")
                .description("Java programming from basics to OOP")
                .price(80.00)
                .status(true)
                .build());

        courses.add(Course.builder()
                .id(UUID.randomUUID())
                .code("b-03")
                .title("Spring Boot Microservices")
                .description("Building Microservices with Spring Boot")
                .price(120.00)
                .status(false)
                .build());

        courses.add(Course.builder()
                .id(UUID.randomUUID())
                .code("b-04")
                .title("Thymeleaf & Spring MVC")
                .description("Full-stack web development with Spring MVC and Thymeleaf")
                .price(95.00)
                .status(true)
                .build());

        courses.add(Course.builder()
                .id(UUID.randomUUID())
                .code("b-05")
                .title("Spring Security Basics")
                .description("Secure your Spring applications")
                .price(70.00)
                .status(false)
                .build());

        courses.add(Course.builder()
                .id(UUID.randomUUID())
                .code("b-06")
                .title("Hibernate and JPA")
                .description("Master database access with Hibernate and JPA")
                .price(90.00)
                .status(false)
                .build());

        courses.add(Course.builder()
                .id(UUID.randomUUID())
                .code("b-07")
                .title("Spring Boot Testing")
                .description("Unit and integration testing with Spring Boot")
                .price(85.00)
                .status(true)
                .build());

        courses.add(Course.builder()
                .id(UUID.randomUUID())
                .code("b-08")
                .title("Docker for Java Developers")
                .description("Containerizing Java apps with Docker")
                .price(110.00)
                .status(true)
                .build());

        courses.add(Course.builder()
                .id(UUID.randomUUID())
                .code("b-09")
                .title("Kubernetes Basics")
                .description("Deploying microservices to Kubernetes")
                .price(130.00)
                .status(true)
                .build());

        courses.add(Course.builder()
                .id(UUID.randomUUID())
                .code("b-10")
                .title("Spring Cloud Essentials")
                .description("Building resilient microservices with Spring Cloud")
                .price(140.00)
                .status(true)
                .build());

    }
}
