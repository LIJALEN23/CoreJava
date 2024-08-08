package com.corejava.basicprogramming;

import java.util.Arrays;

public class ArrayDemo {
    private static void example1() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        var arr2 = Arrays.copyOf(arr, 7);
        arr2[6] = 7;
        for (int i : arr2) {
            System.out.println(i);
        }
    }

    private static void example2() {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9 ,10}
        };

        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //example1();
        example2();
    }
}
