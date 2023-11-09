package com.carga.escolar.domain.service;

import com.carga.escolar.domain.Assignment;
import com.carga.escolar.domain.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<Assignment> getAll() {
        return assignmentRepository.getAll();
    }

    public Optional<Assignment> getAssignment(int assignmentId) {
        return assignmentRepository.getAssignment(assignmentId);
    }

    public Optional<List<Assignment>> getByStudentId(int studentId) {
        return assignmentRepository.getByStudentId(studentId);
    }

    public Assignment save(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Assignment update(Assignment assignment, int assignmentId) {
        return assignmentRepository.update(assignment, assignmentId);
    }

    public boolean delete(int assignmentId) {
        boolean isPresent = getAssignment(assignmentId).isPresent();
        if(isPresent) assignmentRepository.delete(assignmentId);

        return isPresent;
    }

}
