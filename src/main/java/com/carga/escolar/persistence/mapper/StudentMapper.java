package com.carga.escolar.persistence.mapper;

import com.carga.escolar.domain.Student;
import com.carga.escolar.persistence.entity.Alumno;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mappings({
            @Mapping(source = "idAlumno", target = "studentId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellidoMaterno", target = "maternalSurname"),
            @Mapping(source = "apellidoPaterno", target = "paternalSurname"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "celular", target = "phone")
    })
    Student toStudent(Alumno alumno);
    List<Student> toStudents(List<Alumno> alumnos);

    @InheritInverseConfiguration
    @Mapping(target = "asignaciones", ignore = true)
    Alumno toAlumno(Student student);
}
