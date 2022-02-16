package com.lead.finaltask.service.impl;

import com.lead.finaltask.model.entities.Course;
import com.lead.finaltask.model.entities.Student;
import com.lead.finaltask.model.entities.enums.CourseType;
import com.lead.finaltask.repository.StudentRepository;
import com.lead.finaltask.service.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testGetAddDeleteStudent() {
        Student student = getStudent();

        ResponseEntity<Student> studentResult = studentService.save(student);
        List<Student> students = studentService.findAll();
        Assertions.assertThat(students).first()
                .hasFieldOrPropertyWithValue("fullName", "Ivan");

        studentService.deleteStudent(studentResult.getBody().getId());
        Assertions.assertThat(studentService.findAll()).isEmpty();
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