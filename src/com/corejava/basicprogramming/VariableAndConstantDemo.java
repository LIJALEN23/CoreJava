package com.corejava.basicprogramming;

public class VariableAndConstantDemo {
    private static final float PI = 3.14F;

    private static void example1() {
        var num1 = 12;
        var str1 = "Hello";
        var pi = PI;

        enum Size  {
            SMALL,
            MEDIUM,
            LARGE
        };

        var size = Size.LARGE;

        System.out.println(num1);
        System.out.println(str1);
        System.out.println(pi);
        System.out.println(size);
    }


    public static void main(String[] args) {
        example1();
    }
}
