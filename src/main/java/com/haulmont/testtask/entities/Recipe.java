package com.haulmont.testtask.entities;

import java.math.BigInteger;
import java.sql.Date;

public class Recipe {
    public Recipe(long id, long patient, long doctor, Date dateCreacting, Date duration, Priority priority) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.dateCreacting = dateCreacting;
        this.duration = duration;
        this.priority = priority;
    }

    private long id;

    public long getPatient() {
        return patient;
    }

    public void setPatient(long patient) {
        this.patient = patient;
    }

    private long patient;

    public long getDoctor() {
        return doctor;
    }

    public void setDoctor(long doctor) {
        this.doctor = doctor;
    }

    private long doctor;
    private Date dateCreacting;
    private Date duration;
    private Priority priority;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }




    public Date getDateCreacting() {
        return dateCreacting;
    }

    public void setDateCreacting(Date dateCreacting) {
        this.dateCreacting = dateCreacting;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
