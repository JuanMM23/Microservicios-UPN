package com.microservice.course.controller.dto;

public record StudentDTO(String name, String lastName, String email, Long courseId) {
}
