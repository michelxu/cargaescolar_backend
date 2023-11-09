package com.carga.escolar.domain.repository;

import com.carga.escolar.domain.Assignment;

import java.util.List;
import java.util.Optional;

public interface AssignmentRepository {
    List<Assignment> getAll();
    Optional<List<Assignment>> getByStudentId(int studentId);
    Optional<Assignment> getAssignment(int assignmentId);
    Assignment save(Assignment assignment);
    Assignment update(Assignment assignment, int assignmentId); //**********update
    void delete(int assignmentId);
}
