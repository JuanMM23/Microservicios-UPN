package com.microservice.course.client;

import com.microservice.course.controller.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "micro-student", url = "localhost:8080/api/student")
public interface StudentClient {

    @GetMapping("/search-by-course/{courseId}")
    List<StudentDTO> findAllStudentsByCourse(@PathVariable Long courseId);
}
