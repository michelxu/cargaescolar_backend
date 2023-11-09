package com.carga.escolar.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Integer idAlumno;

    private String nombre;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    private String email;

    private String celular;

    @OneToMany(mappedBy = "alumno")
    private List<Asignacion> asignaciones;

    /* ********************************************* */
    /* ************ Getters and Setters ************ */
    /* ********************************************* */

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }
}
