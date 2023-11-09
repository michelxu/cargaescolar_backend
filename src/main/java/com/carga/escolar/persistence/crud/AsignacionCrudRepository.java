package com.carga.escolar.persistence.crud;

import com.carga.escolar.persistence.entity.Asignacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AsignacionCrudRepository extends CrudRepository<Asignacion, Integer> {
    List<Asignacion> findByIdAlumno(int idAlumno);

}
