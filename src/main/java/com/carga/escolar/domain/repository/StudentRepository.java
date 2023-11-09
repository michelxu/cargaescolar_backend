package com.carga.escolar.domain.repository;

import com.carga.escolar.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    List<Student> getAll();
    Optional<Student> getStudent(int studentId);
    Student save(Student student);
    Student update(Student student, int studentId); //**********update
    void delete(int studentId);
}
