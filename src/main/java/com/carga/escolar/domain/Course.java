package com.carga.escolar.domain;

import java.time.LocalDateTime;

public class Course {
    private int courseId;
    private String courseName;
    private String professor;
    private int startTime;
    private String classroom;

    /* ********************************************* */
    /* ************ Getters and Setters ************ */
    /* ********************************************* */

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
 }
