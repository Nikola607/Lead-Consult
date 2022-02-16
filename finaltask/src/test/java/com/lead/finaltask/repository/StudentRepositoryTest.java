package com.lead.finaltask.repository;

import com.lead.finaltask.model.entities.Course;
import com.lead.finaltask.model.entities.Student;
import com.lead.finaltask.model.entities.enums.CourseType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testInit() {
        assertNotNull(studentRepository);
    }

    @Test
    public void testFindStudentsByCourses_courseName() {
        Student student = getStudent();
        studentRepository.save(student);
        List<Student> studentsList = studentRepository.findStudentsByCourses_CourseName("MATH");
        assertNotNull(studentsList);
        assertFalse(studentsList.isEmpty());
        Set<Course> studentCourse = student.getCourses();
        assertEquals("MATH", studentCourse.iterator().next().getCourseName());
    }

    @Test
    public void testFindStudentsByGroupAndCourseName() {
        Student student = getStudent();
        List<Student> studentsList = studentRepository
                .findStudentsByGroupNameAndCourses_CourseName("FIRST", "MATH");
        assertNotNull(studentsList);
        assertFalse(studentsList.isEmpty());
        Set<Course> studentCourse = student.getCourses();
        assertEquals("MATH", studentCourse.iterator().next().getCourseName());
        assertEquals("FIRST", student.getGroupName());
    }

    @Test
    public void testFindStudentsByAgeGreaterThanAndCourses_CourseName() {
        Student student = getStudent();
        List<Student> studentsList = studentRepository
                .findStudentsByAgeGreaterThanAndCourses_CourseName(18, "MATH");
        assertNotNull(studentsList);
        assertFalse(studentsList.isEmpty());
        Set<Course> studentCourse = student.getCourses();
        assertEquals("MATH", studentCourse.iterator().next().getCourseName());
        assertNotEquals(18, student.getAge());
    }

    @Test
    public void testFindAllByGroupName() {
        Student student = getStudent();
        List<Student> studentsList = studentRepository
                .findAllByGroupName("FIRST");
        assertNotNull(studentsList);
        assertFalse(studentsList.isEmpty());
        assertEquals("FIRST", student.getGroupName());
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