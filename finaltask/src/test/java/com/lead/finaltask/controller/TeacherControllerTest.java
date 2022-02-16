package com.lead.finaltask.controller;

import com.lead.finaltask.model.entities.Course;
import com.lead.finaltask.model.entities.Student;
import com.lead.finaltask.model.entities.Teacher;
import com.lead.finaltask.model.entities.enums.CourseType;
import com.lead.finaltask.service.StudentService;
import com.lead.finaltask.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TeacherController.class)
class TeacherControllerTest {

    @MockBean
    TeacherService teacherService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllTeachers() throws Exception{
        Teacher teacher = getTeacher();
        List<Teacher> teachers = Arrays.asList(teacher);

        Mockito.when(teacherService.findAll()).thenReturn(teachers);

        this.mockMvc.perform(get("/teachers"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllTeachersByGroupAndCourseName() throws Exception{
        Teacher teacher = getTeacher();

        List<Teacher> teachers = Arrays.asList(teacher);

        Mockito.when(teacherService.getAllTeachersByGroupAndCourseName("FIRST", "MATH"))
                .thenReturn(teachers);

        this.mockMvc.perform(get("/teachers/group/FIRST/course/MATH"))
                .andExpect(status().isOk());
    }

    @Test
    void getCountOfTeachers() throws Exception{
        Teacher teacher = getTeacher();

        List<Teacher> teachers = Arrays.asList(teacher);

        Mockito.when(teacherService.getCountOfTeachers())
                .thenReturn(Long.valueOf(teachers.size()));

        this.mockMvc.perform(get("/teachers/count"))
                .andExpect(status().isOk());
    }

    private Teacher getTeacher() {
        Course course = new Course();
        course.setCourseName("MATH");
        course.setCourseType(CourseType.MAIN);
        course.setId(Long.parseLong("1"));

        Teacher teacher = new Teacher();
        teacher.setFullName("Ivan");
        teacher.setAge(19);
        teacher.setGroupName("FIRST");
        teacher.setCourse(course);
        return teacher;
    }
}