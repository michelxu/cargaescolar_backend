package com.carga.escolar.persistence;

import com.carga.escolar.domain.Course;
import com.carga.escolar.domain.Student;
import com.carga.escolar.domain.repository.CourseRepository;
import com.carga.escolar.persistence.crud.ClaseCrudRepository;
import com.carga.escolar.persistence.entity.Alumno;
import com.carga.escolar.persistence.entity.Clase;
import com.carga.escolar.persistence.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClaseRepository implements CourseRepository {
    @Autowired
    private ClaseCrudRepository claseCrudRepository;
    @Autowired
    private CourseMapper mapper;


    @Override
    public List<Course> getAll() {
        List<Clase> clases = (List<Clase>) claseCrudRepository.findAll();
        return mapper.toCourses(clases);
    }

    @Override
    public Optional<Course> getCourse(int courseId) {
        return claseCrudRepository.findById(courseId)
                .map(clase -> mapper.toCourse(clase));
    }

    @Override
    public Course save(Course course) {
        Clase clase = mapper.toClase(course);
        return mapper.toCourse(claseCrudRepository.save(clase));
    }

    @Override
    public Course update(Course newCourse, int courseId) {
        Optional<Clase> existingCourse = claseCrudRepository.findById(courseId);

        if(existingCourse.isPresent()) {
            Clase courseToUpdate = existingCourse.get();

            //Update properties, only if are given
            if(newCourse.getProfessor() != null) {
                courseToUpdate.setTutor(newCourse.getProfessor());
            }
            if(newCourse.getClassroom() != null) {
                courseToUpdate.setHoraInicio(newCourse.getStartTime());
            }
            if(newCourse.getClassroom() != null) {
                courseToUpdate.setAula(newCourse.getClassroom());
            }

            //Save
            Clase updatedClase = claseCrudRepository.save(courseToUpdate);
            return mapper.toCourse(updatedClase);
        } else {
            return null;
        }
    }

    @Override
    public void delete(int courseId) {
        claseCrudRepository.deleteById(courseId);
    }
}
