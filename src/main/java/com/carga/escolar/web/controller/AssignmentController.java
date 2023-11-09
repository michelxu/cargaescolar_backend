package com.carga.escolar.web.controller;

import com.carga.escolar.domain.Assignment;
import com.carga.escolar.domain.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/assignments")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/all")
    public List<Assignment> getAll(){
        return assignmentService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Assignment> getAssignment(@PathVariable("id") int assignmentId) {
        return assignmentService.getAssignment(assignmentId);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Assignment>> getByStudentId(@PathVariable("studentId") int studentId) {
        return assignmentService.getByStudentId(studentId)
                .map(students -> new ResponseEntity<>(students, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Assignment> save(@RequestBody Assignment assignment) {
        return new ResponseEntity<>(assignmentService.save(assignment), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Assignment> update(@PathVariable("id") int assignmentId, @RequestBody Assignment assignment) {
        return new ResponseEntity<>(assignmentService.update(assignment, assignmentId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int assignmentId) {
        if(assignmentService.delete(assignmentId))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
