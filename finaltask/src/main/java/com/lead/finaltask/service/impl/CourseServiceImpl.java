package com.lead.finaltask.service.impl;

import com.lead.finaltask.model.entities.Course;
import com.lead.finaltask.repository.CourseRepository;
import com.lead.finaltask.service.CourseService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Long getCountOfCourses() {
        return (long) courseRepository.findAll().size();
    }
}
