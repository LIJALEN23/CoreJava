package com.corejava.collection;

import java.util.*;

public class IteratorDemo {

    private static void example1() {
        List<Integer> list = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }

        Iterator<Integer> iter1 = list.iterator();
        while (iter1.hasNext()) {
            int i = iter1.next();
            System.out.println(i);
        }

        System.out.println("===================");
        iter1.forEachRemaining(n -> System.out.println(n));

        System.out.println("===================");

        for (int i : list) {
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        example1();
    }
}
