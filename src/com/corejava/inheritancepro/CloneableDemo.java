package com.corejava.inheritancepro;

public class CloneableDemo {

    public static void main(String[] args) {

    }
}

class Team implements Cloneable {
    private String name;
    private Person[] teamers;

    public Team(String name, Person[] persons) {
        this.name = name;
        teamers = persons;
    }

    @Override
    public Team clone() throws CloneNotSupportedException {
        Team cloned = (Team) super.clone();

        cloned.teamers = cloned.teamers.clone();

        return cloned;
    }
}
