package com.lead.finaltask.service;

import com.lead.finaltask.model.entities.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    ResponseEntity<Teacher> save(Teacher teacher);

    List<Teacher> findAll();

    ResponseEntity<Teacher> deleteTeacher(Long id);

    ResponseEntity<Teacher> updateTeacher(Teacher teacher);

    List<Teacher> getAllTeachersByGroupAndCourseName(String groupName, String courseName);

    Long getCountOfTeachers();
}
