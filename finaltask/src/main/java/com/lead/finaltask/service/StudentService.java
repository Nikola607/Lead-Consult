package com.lead.finaltask.service;

import com.lead.finaltask.model.entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    ResponseEntity<Student> save(Student student);

    List<Student> findAll();

    ResponseEntity<Student> deleteStudent(Long id);

    ResponseEntity<Student> updateStudent(Student student);

    List<Student> findAllStudentsByCourseName(String courseName);

    List<Student> findAllStudentsByGroupName(String groupName);

    List<Student> findAllStudentsByGroupAndCourseName(String groupName, String courseName);

    List<Student> findAllStudentsByCourseNameAndOlderThanAge(String courseName, int age);

    Long getCountOfStudents();
}
