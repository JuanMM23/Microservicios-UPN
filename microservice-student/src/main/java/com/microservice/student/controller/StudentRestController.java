package com.microservice.student.controller;

import com.microservice.student.entity.Student;
import com.microservice.student.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentRestController {

    private final IStudentService studentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping("/search-by-course/{courseId}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long courseId){
        return ResponseEntity.ok(studentService.findByCourseId(courseId));
    }
}
