package com.carga.escolar.persistence;

import com.carga.escolar.domain.Student;
import com.carga.escolar.domain.repository.StudentRepository;
import com.carga.escolar.persistence.crud.AlumnoCrudRepository;
import com.carga.escolar.persistence.entity.Alumno;
import com.carga.escolar.persistence.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlumnoRepository implements StudentRepository {
    @Autowired //cede el control a spring para que cree estas instancias y no sean nulas
    private AlumnoCrudRepository alumnoCrudRepository;
    @Autowired
    private StudentMapper mapper;

    @Override
    public List<Student> getAll() {
        List<Alumno> alumnos = (List<Alumno>) alumnoCrudRepository.findAll();
        return mapper.toStudents(alumnos);
    }

    @Override
    public Optional<Student> getStudent(int studentId) {
        return alumnoCrudRepository.findById(studentId)
                .map(alumno -> mapper.toStudent(alumno));
    }

    @Override
    public Student save(Student student) {
        Alumno alumno = mapper.toAlumno(student);
        return mapper.toStudent(alumnoCrudRepository.save(alumno));
    }

    @Override
    public Student update(Student newStudent, int studentId) {
        Optional<Alumno> existingStudent = alumnoCrudRepository.findById(studentId);

        /*Si existe un Assignment, pasa todos los valores del existente a uno nuevo,
        este nuevo (assignmentToUpdate) sólo modifica los valores que se pasaron */
        if (existingStudent.isPresent()) {
            Alumno studentToUpdate = existingStudent.get();

            //Update properties, only if are given
            if (newStudent.getEmail() != null) {
                studentToUpdate.setEmail(newStudent.getEmail());
            }
            if (newStudent.getPhone() != null) {
                studentToUpdate.setCelular(newStudent.getPhone());
            }

            //Save
            Alumno updatedAlumno = alumnoCrudRepository.save(studentToUpdate);

            return mapper.toStudent(updatedAlumno);
        } else {
            return null;
        }
    }

    @Override
    public void delete(int studentId) {
        alumnoCrudRepository.deleteById(studentId);
    }
}
