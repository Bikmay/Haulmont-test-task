package com.haulmont.testtask.entities;

import java.math.BigInteger;

public class Patient {
    private long id;
    private String name;
    private String surname;
    private String secondName;
    private int phone;

    public Patient(String name, String surname, String secondName, int phone) {
        this(0,name,surname,secondName,phone);
    }

    public Patient(long id, String name, String surname, String secondName, int phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
        this.phone = phone;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
