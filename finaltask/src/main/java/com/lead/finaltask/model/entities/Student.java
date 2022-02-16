package com.lead.finaltask.model.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "students")
public class Student extends BaseEntity {
    @Column(nullable = false)
    @NotBlank(message = "Name cannot be empty.")
    private String fullName;

    @Column(nullable = false)
    @Min(value = 1, message = "Age should not be below 1.")
    @Max(value = 99, message = "Age should not be greater than 99.")
    private int age;

    @Column(nullable = false)
    @NotBlank(message = "Group name cannot be empty.")
    private String groupName;

    private Set<Course> courses;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @NotNull(message = "Courses cannot be null.")
    public Set<Course> getCourses() {
        if(courses == null){
            courses = new HashSet<>();
        }
        return courses;
    }

    public void setCourses(Set<Course> studentCourses) {
        this.courses = studentCourses;
    }
}
