package com.carga.escolar.web.controller;

import com.carga.escolar.domain.Course;
import com.carga.escolar.domain.Student;
import com.carga.escolar.domain.service.CourseService;
import com.carga.escolar.domain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public List<Course> getAll(){
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourse(@PathVariable("id") int courseId) {
        return courseService.getCourse(courseId);
    }

    @PostMapping("/save")
    public Course save(@RequestBody Course course) {
        return courseService.save(course);
    }

    @PutMapping("/update/{id}")
    public Course update(@PathVariable("id") int courseId, @RequestBody Course course) {
        return courseService.update(course, courseId);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int courseId) {
        return courseService.delete(courseId);
    }
}
