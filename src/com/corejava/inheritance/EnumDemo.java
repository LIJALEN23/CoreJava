package com.corejava.inheritance;

public class EnumDemo {
    private static void example1() {
        Size small = Size.SMALL;
        Size medium = Size.MEDIUM;
        Size large = Enum.valueOf(Size.class, "LARGE");

        System.out.println(large.ordinal());
    }
    public static void main(String[] args) {
        example1();
    }
}

enum Size {
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L");

    private String abbreviation;

    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}