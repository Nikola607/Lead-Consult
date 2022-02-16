package com.lead.finaltask.model.entities;

import com.lead.finaltask.model.entities.enums.CourseType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "school_courses")
public class Course extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    @NotNull(message = "Course type cannot be null.")
    private CourseType courseType;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Course name cannot be null.")
    private String courseName;

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
