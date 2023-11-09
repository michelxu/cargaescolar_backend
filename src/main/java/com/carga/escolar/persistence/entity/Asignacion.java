package com.carga.escolar.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "asignaciones")
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion")
    private Integer idAsignacion;

    @Column(name = "id_alumno")
    private Integer idAlumno;

    @Column(name = "id_clase")
    private Integer idClase;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_alumno", insertable = false, updatable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_clase", insertable = false, updatable = false)
    private Clase clase;

    /* ********************************************* */
    /* ************ Getters and Setters ************ */
    /* ********************************************* */

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
