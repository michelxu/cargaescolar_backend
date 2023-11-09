package com.carga.escolar.persistence;

import com.carga.escolar.domain.Assignment;
import com.carga.escolar.domain.repository.AssignmentRepository;
import com.carga.escolar.persistence.crud.AsignacionCrudRepository;
import com.carga.escolar.persistence.entity.Asignacion;
import com.carga.escolar.persistence.mapper.AssignmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class AsignacionRepository implements AssignmentRepository {
    @Autowired //cede el control a spring para que cree estas instancias y no sean nulas
    private AsignacionCrudRepository asignacionCrudRepository;
    @Autowired
    private AssignmentMapper mapper;

    @Override
    public List<Assignment> getAll() {
        List<Asignacion> asignaciones = (List<Asignacion>) asignacionCrudRepository.findAll();
        return mapper.toAssignments(asignaciones);
    }

    @Override
    public Optional<List<Assignment>> getByStudentId(int studentId) {
        List<Asignacion> asignaciones = asignacionCrudRepository.findByIdAlumno(studentId);
        return Optional.of(mapper.toAssignments(asignaciones));
    }

    @Override
    public Optional<Assignment> getAssignment(int assignmentId) {
        return asignacionCrudRepository.findById(assignmentId)
                .map(asignacion -> mapper.toAssignment(asignacion));
    }

    @Override
    public Assignment save(Assignment assignment) {
        Asignacion asignacion = mapper.toAsignacion(assignment);

        //Set timestamp (current date and time)
        asignacion.setFechaCreacion(LocalDateTime.now());

        return mapper.toAssignment(asignacionCrudRepository.save(asignacion));
    }

    @Override
    public Assignment update(Assignment newAssignment, int assignmentId) {
        Optional<Asignacion> existingAssignment = asignacionCrudRepository.findById(assignmentId);

        if (existingAssignment.isPresent()) {
            Asignacion assignmentToUpdate = existingAssignment.get();

            //Update properties, only if are given
            if (newAssignment.getStudentId() != -1) {
                assignmentToUpdate.setIdAlumno(newAssignment.getStudentId());
            }
            if (newAssignment.getCourseId() != -1) {
                assignmentToUpdate.setIdClase(newAssignment.getCourseId());
            }

            //Save
            Asignacion updatedAsignacion = asignacionCrudRepository
                    .save(assignmentToUpdate);

            return mapper.toAssignment(updatedAsignacion);
        } else {
            return null;
        }
    }

    @Override
    public void delete(int assignmentId) {
        asignacionCrudRepository.deleteById(assignmentId);
    }
}
