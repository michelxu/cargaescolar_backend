package com.carga.escolar.domain.repository;

import com.carga.escolar.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    List<Course> getAll();
    Optional<Course> getCourse(int courseId);
    Course save (Course course);
    Course update(Course course, int courseId); //**********update
    void delete(int courseId);
}
