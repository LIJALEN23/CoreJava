package com.corejava.basicprogramming;

public class StringDemo {
    private static void example1() {
        String str1 = "Hello, Lijalen!";
        String str2 = str1.substring(0, 5);
        if (str2.length() == 5 - 0) {
            System.out.println(str2);
        }

    }

    private static void example2() {
        String str1 = String.join(" ", "l", "i", "j", "a", "l", "e", "n");
        System.out.println(str1);
        System.out.println(str1.repeat(3));
    }

    private static void example3() {
        String str1 = "Wuling";
        int length = str1.length();
        int cpLength = str1.codePointCount(0, length);

        System.out.println("length = " + length);
        System.out.println("Code point length = " + cpLength);
    }

    private static void example4() {
        String str1 = "Hello,world!";
        int[] codePoints = str1.codePoints().toArray();
        System.out.println("str1.length = " + str1.length() + "   codePoints.length = " + codePoints.length);
        for (int i : codePoints) {
            System.out.print(i + " ");
        }

        String str2 = new String(codePoints, 0, codePoints.length);
        System.out.println("\n" + str2);
    }

    private static void example5() {
        StringBuilder str1 = new StringBuilder("Hello,world!");

        str1.append("Lijalen");
        str1.append("  Wuling");
        str1.append(8.7);
        str1.append(234);
        String str2 = str1.toString();
        System.out.println(str2);
    }

    public static void main(String[] args) {
        //example1();
        //example2();
        //example3();
        //example4();
        example5();
    }
}
