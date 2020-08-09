package com.haulmont.testtask.entities;

public enum Priority {
    NORMAL(1),
    CITO(2),
    STATIUM(3);

    private int number;

    Priority(int number){
        this.number=number;
    }

    public int getNumber(){
        return number;
    }
}
