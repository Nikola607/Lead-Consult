package com.lead.finaltask.initialize;

import com.lead.finaltask.model.entities.Course;
import com.lead.finaltask.model.entities.enums.CourseType;
import com.lead.finaltask.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitialize implements CommandLineRunner {
    private final CourseRepository courseRepository;

    public DBInitialize(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initializeCourses();
    }

    public void initializeCourses() {
        if (courseRepository.count() > 0) {
            return;
        }

        Course mainCourse = new Course();
        mainCourse.setCourseType(CourseType.MAIN);
        mainCourse.setCourseName("MATH");
        courseRepository.save(mainCourse);

        Course secondaryCourse = new Course();
        secondaryCourse.setCourseType(CourseType.SECONDARY);
        secondaryCourse.setCourseName("ENGLISH");
        courseRepository.save(secondaryCourse);
    }
}
