package com.carga.escolar.persistence.crud;

import com.carga.escolar.persistence.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AlumnoCrudRepository extends CrudRepository<Alumno, Integer> {

}
