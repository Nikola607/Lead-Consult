package com.lead.finaltask.repository;

import com.lead.finaltask.model.entities.Course;
import com.lead.finaltask.model.entities.Student;
import com.lead.finaltask.model.entities.Teacher;
import com.lead.finaltask.model.entities.enums.CourseType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void findTeachersByGroupNameAndCourse_CourseName() {
      Teacher teacher = getTeacher();
      teacherRepository.save(teacher);
      List<Teacher> teacherList = teacherRepository
              .findTeachersByGroupNameAndCourse_CourseName("FIRST", "MATH");
      assertNotNull(teacherList);
      assertFalse(teacherList.isEmpty());
      String teacherCourse = teacher.getCourse().getCourseName();
      assertEquals("MATH", teacherCourse);
      assertEquals("FIRST", teacher.getGroupName());
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