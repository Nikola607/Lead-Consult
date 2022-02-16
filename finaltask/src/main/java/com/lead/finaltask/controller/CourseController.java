package com.lead.finaltask.controller;

import com.lead.finaltask.model.entities.Course;
import com.lead.finaltask.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.findAll();
    }

    @GetMapping("/courses/count")
    public Long getCountOfCourses(){
        return courseService.getCountOfCourses();
    }
}
