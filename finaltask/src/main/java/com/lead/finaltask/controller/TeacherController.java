package com.lead.finaltask.controller;

import com.lead.finaltask.model.entities.Teacher;
import com.lead.finaltask.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping("/teacher")
    public ResponseEntity<Teacher> addTeacher(@Valid @RequestBody Teacher teacher) {
        ResponseEntity<Teacher> saveTeacher = null;

        try {
            saveTeacher = teacherService.save(teacher);
        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
        }

        return saveTeacher;
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.findAll();
    }

    @DeleteMapping("/teacher/{id}")
    public ResponseEntity<Teacher> deleteTeacher(@Valid @PathVariable Long id) {
        ResponseEntity<Teacher> deleteTeacher = teacherService.deleteTeacher(id);

        return deleteTeacher;
    }

    @PutMapping("/teacher")
    public ResponseEntity<Teacher> updateTeacher(@Valid @RequestBody Teacher teacher) {

        ResponseEntity<Teacher> updateTeacher = teacherService.updateTeacher(teacher);

        return updateTeacher;
    }

    @GetMapping("/teachers/group/{groupName}/course/{courseName}")
    public List<Teacher> getAllTeachersByGroupAndCourseName(@PathVariable String groupName,
                                                            @PathVariable String courseName) {
        return teacherService.getAllTeachersByGroupAndCourseName(groupName, courseName);
    }

    @GetMapping("/teachers/count")
    public Long getCountOfTeachers() {
        return teacherService.getCountOfTeachers();
    }
}
