package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.controller.dto.StudentDTO;
import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentsByCourseResponse;
import com.microservice.course.persistence.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService{

    private final CourseRepository courseRepository;
    private final StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentsByCourseResponse findStudentsByCourseId(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow();

        List<StudentDTO> studentDTOList = studentClient.findAllStudentsByCourse(course.getId());

        return StudentsByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
