package com.corejava.basicprogramming;

public class DataTypeDemo {
    private static void example1() {
        int minInt = Integer.MIN_VALUE;
        int maxInt = Integer.MAX_VALUE;
        System.out.println("minInt : " + minInt + "  maxInt : " + maxInt);

        long num1 = 1000000000000000L;
        int num2 = 0X123252;
        int num3 = 01034325;
        float num4 = 0.234F;
        double num5 = 0.3423525D;
        int num6 = 0b10010101;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num3 = " + num3);
        System.out.println("num4 = " + num4);
        System.out.println("num5 = " + num5);
        System.out.println("num6 = " + num6);

    }

    private static void example2() {

        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.NaN);

        double num1 = 0.3423224D;
        if (Double.isInfinite(num1)) {
            System.out.println("num1  is infinite");
        } else {
            System.out.println("num1 is not infinite");
        }
    }

    private static void example3() {
        char ch1 = '\u2122';
        char ch2 = '\u03C0';
        System.out.println("ch1 = " + ch1 + "\nch2 = " + ch2);
    }

    public static void main(String[] args) {
        //example1();

        //example2();

        example3();
    }
}
