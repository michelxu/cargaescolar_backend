package com.carga.escolar.domain.service;

import com.carga.escolar.domain.Student;
import com.carga.escolar.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public Optional<Student> getStudent(int studentId) {
        return studentRepository.getStudent(studentId);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Student student, int studentId) {
        return studentRepository.update(student, studentId);
    }

    public boolean delete(int studentId) {
        boolean isPresent = getStudent(studentId).isPresent();
        if(isPresent) studentRepository.delete(studentId);

        return isPresent;
    }
}
