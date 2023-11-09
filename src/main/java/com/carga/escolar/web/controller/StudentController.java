package com.carga.escolar.web.controller;

import com.carga.escolar.domain.Student;
import com.carga.escolar.domain.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private static final HttpStatus HTTP_OK = HttpStatus.OK;
    private static final HttpStatus HTTP_NOT_FOUND = HttpStatus.NOT_FOUND;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(studentService.getAll(), HTTP_OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int studentId) {
        return studentService.getStudent(studentId)
                .map(student -> new ResponseEntity<>(student, HTTP_OK))
                .orElse(new ResponseEntity<>(HTTP_NOT_FOUND));
    }

    @PostMapping("/save")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/update/{id}")
    public Student update(@PathVariable("id") int studentId, @RequestBody Student student) {
        return studentService.update(student, studentId);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int studentId) {
        return studentService.delete(studentId);
    }
}
