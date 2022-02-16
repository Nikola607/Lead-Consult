package com.lead.finaltask.controller;

import com.lead.finaltask.model.entities.Course;
import com.lead.finaltask.model.entities.Student;
import com.lead.finaltask.model.entities.enums.CourseType;
import com.lead.finaltask.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @MockBean
    StudentService studentService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllStudents() throws Exception {
        Student student = getStudent();
        List<Student> students = Arrays.asList(student);

        Mockito.when(studentService.findAll()).thenReturn(students);

        this.mockMvc.perform(get("/students"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllStudentsByCourseName() throws Exception {
        Student student = getStudent();

        List<Student> students = Arrays.asList(student);

        Mockito.when(studentService.findAllStudentsByCourseName("MATH")).thenReturn(students);

        this.mockMvc.perform(get("/students/course/MATH"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllStudentsByGroupName() throws Exception {
        Student student = getStudent();

        List<Student> students = Arrays.asList(student);

        Mockito.when(studentService.findAllStudentsByGroupName("FIRST")).thenReturn(students);

        this.mockMvc.perform(get("/students/group/FIRST"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllStudentsByGroupAndCourseName() throws Exception {
        Student student = getStudent();

        List<Student> students = Arrays.asList(student);

        Mockito.when(studentService.findAllStudentsByGroupAndCourseName("FIRST", "MATH"))
                .thenReturn(students);

        this.mockMvc.perform(get("/students/group/FIRST/course/MATH"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllStudentsByCourseNameAndOlderThanAge() throws Exception {
        Student student = getStudent();

        List<Student> students = Arrays.asList(student);

        Mockito.when(studentService.findAllStudentsByCourseNameAndOlderThanAge("MATH", 18))
                .thenReturn(students);

        this.mockMvc.perform(get("/students/course/MATH/age/18"))
                .andExpect(status().isOk());
    }

    @Test
    void getCountOfStudents() throws Exception {
        Student student = getStudent();
        List<Student> students = Arrays.asList(student);

        Mockito.when(studentService.getCountOfStudents()).thenReturn(Long.valueOf(students.size()));

        this.mockMvc.perform(get("/students/count"))
                .andExpect(status().isOk());
    }

    private Student getStudent() {
        Course course = new Course();
        course.setCourseName("MATH");
        course.setCourseType(CourseType.MAIN);
        course.setId(Long.parseLong("1"));

        Set<Course> courses = new HashSet<>();
        courses.add(course);

        Student student = new Student();
        student.setFullName("Ivan");
        student.setAge(19);
        student.setGroupName("FIRST");
        student.setCourses(courses);
        return student;
    }
}