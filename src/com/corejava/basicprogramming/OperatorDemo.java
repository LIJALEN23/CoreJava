package com.corejava.basicprogramming;

public class OperatorDemo {
    private static void example1() {
        System.out.println(Math.multiplyExact(10_0000_0000, 3));
    }

    private static void example2() {
        double num1 = 123.32425D;
        //强制类型转换
        int num2 = (int) Math.round(num1);

    }

    public static void main(String[] args) {
        example1();

    }
}
