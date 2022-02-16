package com.lead.finaltask.controller;

import com.lead.finaltask.model.entities.Student;
import com.lead.finaltask.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        ResponseEntity<Student> saveStudent = studentService.save(student);

        return saveStudent;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> deleteStudent(@Valid @PathVariable Long id) {
        ResponseEntity<Student> deleteStudent = studentService.deleteStudent(id);

        return deleteStudent;
    }

    @PutMapping("/student")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) {
        ResponseEntity<Student> updateStudent = studentService.updateStudent(student);

        return updateStudent;
    }

    @GetMapping("/students/course/{courseName}")
    public List<Student> getAllStudentsByCourseName(@PathVariable String courseName) {
        return studentService.findAllStudentsByCourseName(courseName);
    }

    @GetMapping("/students/group/{groupName}")
    public List<Student> getAllStudentsByGroupName(@PathVariable String groupName) {
        return studentService.findAllStudentsByGroupName(groupName);
    }

    @GetMapping("/students/group/{groupName}/course/{courseName}")
    public List<Student> getAllStudentsByGroupAndCourseName(@PathVariable String courseName,
                                                            @PathVariable String groupName) {
        return studentService.findAllStudentsByGroupAndCourseName(groupName, courseName);
    }

    @GetMapping("/students/course/{courseName}/age/{age}")
    public List<Student> getAllStudentsByCourseNameAndOlderThanAge(@PathVariable String courseName,
                                                                   @PathVariable String age) {
        return studentService.findAllStudentsByCourseNameAndOlderThanAge(courseName, Integer.parseInt(age));
    }

    @GetMapping("/students/count")
    public Long getCountOfStudents() {
        return studentService.getCountOfStudents();
    }
}
