package com.corejava.inheritancepro;

import java.util.Arrays;
import java.util.Iterator;

public class ComparableDemo {
    private static void example1() {
        Person lijalen = new Person("lijalen", 19);
        Person durant = new Person("Durant", 35);

        if (lijalen.compareTo(durant) < 0) {
            System.out.println("lijalen 年龄比 durant 小");
        }
    }

    private static void example2() {
        Person lijalen = new Person("lijalen", 19);
        Person durant = new Person("Durant", 35);
        Person miles = new Person("miles", 18);

        Person[] persons = new Person[3];
        persons[0] = lijalen;
        persons[1] = durant;
        persons[2] = miles;

        java.util.Arrays.sort(persons);

        for (Person p : persons) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        //example1();
        example2();
    }
}

class Person implements Comparable<Person> {
    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.age + " years old";
    }

    @Override
    public int compareTo(Person o) {
        if (getClass() != o.getClass()) {
            throw new ClassCastException();
        }
        return Integer.compare(this.age, o.age);
    }
}
