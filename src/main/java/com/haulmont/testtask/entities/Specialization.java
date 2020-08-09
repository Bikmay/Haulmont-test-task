package com.haulmont.testtask.entities;

import java.math.BigInteger;

public class Specialization {
    private long id;
    private String title;

    public Specialization(long id, String name) {
        this.id = id;
        this.title = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }
}
