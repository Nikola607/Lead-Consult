package com.lead.finaltask.repository;

import com.lead.finaltask.model.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findTeachersByGroupNameAndCourse_CourseName(String groupName,
                                                                     String teacherCourses_courseName);
}
