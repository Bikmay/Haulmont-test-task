package com.haulmont.testtask.entities;

import java.math.BigInteger;

public class Doctor {
    private long id;
    private String name;
    private String surname;
    private String secondName;
    private Specialization specialization;

    public Doctor(String name, String surname, String secondName, Specialization specialization) {
        this(0,name,surname,secondName,specialization);
    }

    public Doctor(long id, String name, String surname, String secondName, Specialization specialization) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
        this.specialization = specialization;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
