package com.lead.finaltask.service;

import com.lead.finaltask.model.entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> findAll();

    Long getCountOfCourses();
}
