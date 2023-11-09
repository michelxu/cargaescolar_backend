package com.carga.escolar.domain.service;

import com.carga.escolar.domain.Course;
import com.carga.escolar.domain.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    public Optional<Course> getCourse(int courseId) {
        return courseRepository.getCourse(courseId);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public Course update(Course course, int courseId) {
        return courseRepository.update(course, courseId);
    }

    public boolean delete(int courseId) {
        boolean isPresent = getCourse(courseId).isPresent();
        if(isPresent) courseRepository.delete(courseId);

        return isPresent;
    }
}
