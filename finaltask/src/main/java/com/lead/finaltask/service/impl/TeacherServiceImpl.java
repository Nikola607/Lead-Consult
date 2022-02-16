package com.lead.finaltask.service.impl;

import com.lead.finaltask.model.entities.Teacher;
import com.lead.finaltask.repository.TeacherRepository;
import com.lead.finaltask.service.TeacherService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public ResponseEntity<Teacher> save(Teacher teacher) {
        return new ResponseEntity<>(teacherRepository.save(teacher), HttpStatus.ACCEPTED);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public ResponseEntity<Teacher> deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Teacher> updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        return new ResponseEntity<>(teacherRepository.save(teacher), HttpStatus.OK);
    }

    @Override
    public List<Teacher> getAllTeachersByGroupAndCourseName(String groupName, String courseName) {
        return teacherRepository.findTeachersByGroupNameAndCourse_CourseName(groupName, courseName);
    }

    @Override
    public Long getCountOfTeachers() {
        return (long) teacherRepository.findAll().size();
    }
}
