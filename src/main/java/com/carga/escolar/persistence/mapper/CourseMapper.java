package com.carga.escolar.persistence.mapper;

import com.carga.escolar.domain.Course;
import com.carga.escolar.persistence.entity.Clase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mappings({
            @Mapping(source = "idClase", target = "courseId"),
            @Mapping(source = "nombreMateria", target = "courseName"),
            @Mapping(source = "tutor", target = "professor"),
            @Mapping(source = "horaInicio", target = "startTime"),
            @Mapping(source = "aula", target = "classroom")
    })
    Course toCourse(Clase clase);
    List<Course> toCourses(List<Clase> clases);

    @InheritInverseConfiguration
    @Mapping(target = "asignaciones", ignore = true)
    Clase toClase(Course course);
}
