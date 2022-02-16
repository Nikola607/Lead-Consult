package com.lead.finaltask.repository;

import com.lead.finaltask.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByGroupName(String groupName);

    List<Student> findStudentsByCourses_CourseName(String name);

    List<Student> findStudentsByGroupNameAndCourses_CourseName(String groupName, String courseName);

    List<Student> findStudentsByAgeGreaterThanAndCourses_CourseName(int age, String courseName);
}
