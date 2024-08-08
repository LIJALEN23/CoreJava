package com.corejava.basicprogramming;

import java.math.*;

public class BigNumberDemo {
    private static void example1() {
        BigInteger num1 = new BigInteger(Long.MAX_VALUE + "133");
        BigInteger num3 = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger num2 = new BigInteger(Long.MAX_VALUE + "2224");

        System.out.println(Long.MAX_VALUE);
        System.out.println(num1.add(num2));
    }

    private static void example2() {
        BigDecimal num1 = BigDecimal.valueOf(23432L, 2);
        BigDecimal num2 = BigDecimal.valueOf(23423432.23D);

        //num1.divide(num2);
        num1.divide(num2, RoundingMode.HALF_UP);
    }


    public static void main(String[] args) {
        //example1();
        example2();
    }
}
