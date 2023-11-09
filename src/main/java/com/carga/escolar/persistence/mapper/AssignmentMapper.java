package com.carga.escolar.persistence.mapper;

import com.carga.escolar.domain.Assignment;
import com.carga.escolar.persistence.entity.Asignacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, CourseMapper.class})
public interface AssignmentMapper {
    @Mappings({
            @Mapping(source = "idAsignacion", target = "assignmentId"),
            @Mapping(source = "idAlumno", target = "studentId"),
            @Mapping(source = "idClase", target = "courseId"),
            @Mapping(source = "fechaCreacion", target = "createdAt"),
            @Mapping(source = "alumno", target = "student"),
            @Mapping(source = "clase", target = "course")
    })

    Assignment toAssignment(Asignacion asignacion);
    List<Assignment> toAssignments(List<Asignacion> asignaciones);

    @InheritInverseConfiguration
    Asignacion toAsignacion(Assignment assignment);
}
