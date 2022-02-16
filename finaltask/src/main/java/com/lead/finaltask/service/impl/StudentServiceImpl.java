package com.lead.finaltask.service.impl;

import com.lead.finaltask.model.entities.Student;
import com.lead.finaltask.repository.StudentRepository;
import com.lead.finaltask.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<Student> save(Student student) {
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);

    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public ResponseEntity<Student> deleteStudent(Long id) {

        studentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Student> updateStudent(Student student) {

        studentRepository.save(student);
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.ACCEPTED);
    }

    @Override
    public List<Student> findAllStudentsByCourseName(String courseName) {

        return studentRepository.findStudentsByCourses_CourseName(courseName);
    }

    @Override
    public List<Student> findAllStudentsByGroupName(String groupName) {
        return studentRepository.findAllByGroupName(groupName);
    }

    @Override
    public List<Student> findAllStudentsByGroupAndCourseName(String groupName, String courseName) {
        return studentRepository.findStudentsByGroupNameAndCourses_CourseName(groupName, courseName);
    }

    @Override
    public List<Student> findAllStudentsByCourseNameAndOlderThanAge(String courseName, int age) {
        return studentRepository.findStudentsByAgeGreaterThanAndCourses_CourseName(age, courseName);
    }

    @Override
    public Long getCountOfStudents() {
        return (long) studentRepository.findAll().size();
    }
}
