package com.corejava.inheritance;

import java.util.*;

public class InstanceofDemo {

    private static void example1() {
        Collection<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = null;

        if (list1 instanceof List) {
            list2 = (List<Integer>) list1;
            System.out.println("list1声明类型为Collection，list2声明类型为List。即list1为list2的父类，用instanceof进行判断并强制类型转换");
        }


    }

    public static void main(String... args) {
        example1();
    }
}
