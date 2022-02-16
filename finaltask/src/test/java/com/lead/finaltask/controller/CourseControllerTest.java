package com.lead.finaltask.controller;

import com.lead.finaltask.model.entities.Course;
import com.lead.finaltask.model.entities.enums.CourseType;
import com.lead.finaltask.service.CourseService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CourseController.class)
class CourseControllerTest {

    @MockBean
    CourseService courseService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllCourses() throws Exception{
      Course course = getCourse();
      List<Course> courses = Arrays.asList(course);

      Mockito.when(courseService.findAll()).thenReturn(courses);

      this.mockMvc.perform(get("/courses"))
              .andExpect(status().isOk());
    }

    @Test
    void getCountOfCourses() throws Exception{
        Course course = getCourse();
        List<Course> courses = Arrays.asList(course);

        Mockito.when(courseService.getCountOfCourses()).thenReturn(Long.valueOf(courses.size()));

        this.mockMvc.perform(get("/courses"))
                .andExpect(status().isOk());
    }

    private Course getCourse() {
        Course course = new Course();
        course.setCourseName("MATH");
        course.setCourseType(CourseType.MAIN);
        course.setId(Long.parseLong("1"));
        return course;
    }
}