package com.corejava.generic;

public class BoundDemo {

    private static <T extends Comparable<T>> void compare(T first, T second) {
        int cmp = first.compareTo(second);
        if (cmp > 0) {
            System.out.println("First is bigger");
        } else if (cmp < 0) {
            System.out.println("Second is bigger");
        } else {
            System.out.println("First is as big as second");
        }
    }

    private static void example1() {
        String lijalen = "lijalen";
        String durant = "durant";
        compare(lijalen, durant);
    }

    public static void main(String[] args) {
        example1();
    }
}
