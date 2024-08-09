package com.corejava.inheritance;

import java.lang.reflect.InvocationTargetException;

public class ClassDemo {
    private static void example1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class cl = Class.forName("java.time.LocalDate");
        Object obj = cl.getConstructor().newInstance();
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        example1();
    }
}
