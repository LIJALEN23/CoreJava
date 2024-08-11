package com.corejava.inheritancepro;

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class LambdaDemo {
    private static void example1() {
        Person lijalen = new Person("lijalen", 19);
        Person durant = new Person("Durant", 35);
        Person miles = new Person("miles", 18);

        Person[] persons = new Person[3];
        persons[0] = lijalen;
        persons[1] = durant;
        persons[2] = miles;

        Arrays.sort(persons, (Person p1, Person p2) -> {
            return Integer.compare(p1.getAge(), p2.getAge());
        });

        Arrays.sort(persons, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())
        );
    }

    private static void example2() {
        var planets = new String[] {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length: ");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        var timer = new Timer(1000, event -> System.out.println("The time is " + new Date()));
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

    public static void main(String[] args) {

        example2();
    }
}
