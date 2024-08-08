package com.corejava.objectandclass;

import java.util.Objects;

public class Instructor {
    private String name;
    private Integer salary;

    public Instructor(String n, Integer s) {
        Objects.requireNonNull(n, "The instructor's name is a null pointer!");
        name = n;
        salary = Objects.requireNonNullElse(s, Integer.getInteger("2500"));
    }
}
