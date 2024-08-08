package com.corejava.objectandclass;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class DateDemo {
    private static void example1() {
        Date deadline = new Date();
        System.out.println(deadline.toString());
    }

    private static void example2() {
        LocalDate birthday = LocalDate.of(2005, 9, 26);
        LocalDate now = birthday.plusYears(19);

        System.out.println("The year of now is : " + now.getYear());
    }

    private static void example3() {
        //获得当前时间
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        //将时间设为本月的第一天
        date = date.minusDays(today - 1);
        //获得本月第一天的星期
        DayOfWeek weekday = date.getDayOfWeek();
        //转换为int值
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sum");
        for (int i = 1; i < value; i++) {
            System.out.print("          ");
            while (date.getMonthValue() == month) {
                System.out.printf("%3d", date.getDayOfMonth());
                if (date.getDayOfMonth() == today)
                    System.out.print("*");
                else
                    System.out.print(" ");
                date = date.plusDays(1);
                if (date.getDayOfWeek().getValue() == 1) System.out.println();
            }
            if (date.getDayOfWeek().getValue() != 1) System.out.println();
        }
    }

    public static void main(String[] args) {
        //example1();
        //example2();
        example3();
    }
}
