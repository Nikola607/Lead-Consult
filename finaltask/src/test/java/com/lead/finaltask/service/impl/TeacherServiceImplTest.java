package com.lead.finaltask.service.impl;

import com.lead.finaltask.model.entities.Course;
import com.lead.finaltask.model.entities.Student;
import com.lead.finaltask.model.entities.Teacher;
import com.lead.finaltask.model.entities.enums.CourseType;
import com.lead.finaltask.service.TeacherService;
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
class TeacherServiceImplTest {
    @Autowired
    private TeacherService teacherService;

    @Test
    public void testGetAddDeleteTeacher() {
        Teacher teacher = getTeacher();

        ResponseEntity<Teacher> teacherResult = teacherService.save(teacher);
        List<Teacher> teachers = teacherService.findAll();
        Assertions.assertThat(teachers).first()
                .hasFieldOrPropertyWithValue("fullName", "Ivan");

        teacherService.deleteTeacher(teacherResult.getBody().getId());
        Assertions.assertThat(teacherService.findAll()).isEmpty();
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