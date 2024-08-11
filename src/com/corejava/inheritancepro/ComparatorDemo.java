package com.corejava.inheritancepro;

import java.util.Comparator;

public class ComparatorDemo {
    private static void example1() {
        Person lijalen = new Person("lijalen", 19);
        Person durant = new Person("Durant", 35);

        var comparator = new AgeComparator();
        if (comparator.compare(lijalen, durant) < 0) {
            System.out.println("lijalen 年龄比 durant 小");
        }
    }

    public static void main(String[] args) {
        example1();
    }
}

class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
