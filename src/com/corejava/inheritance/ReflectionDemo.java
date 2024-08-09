package com.corejava.inheritance;

import java.util.*;
import java.lang.reflect.*;

public class ReflectionDemo {

    private static void printConstructor(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();

            System.out.print("    ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    private static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("    ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    private static void printFields(Class cl) {
        Field[] fields = cl.getFields();

        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }


    private static void example1() {
        Double num = 1223.455;

        Class cl = num.getClass();
        Class superCl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length() > 0) System.out.print(modifiers + " ");
        System.out.print("class " + cl.getName());
        if (superCl != null && superCl != Object.class) System.out.print(" extends " + superCl.getName());

        System.out.print("\n{\n");
        printConstructor(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printMethods(cl);
        System.out.println("}");
    }

    private static Object[] badArrayCopy(Object[] oldArray, int newLength) {
        var newArray = new Object[newLength];

        System.arraycopy(oldArray, 0, newArray, 0, Math.min(oldArray.length, newLength));

        return newArray;
    }

    private static Object goodArrayCopy(Object oldArray, int newlength) {
        Class cl = oldArray.getClass();
        if (!cl.isArray()) return null;

        Class componentType = cl.getComponentType();
        int oldLength = Array.getLength(oldArray);
        Object newArray = Array.newInstance(componentType, newlength);
        System.arraycopy(oldArray, 0, newArray, 0, Math.min(oldLength, newlength));

        return newArray;
    }


    private static void example2() {

    }

    private static void objectAnalyzer() throws ReflectiveOperationException {
        var squares = new ArrayList<Integer>();
        for (int i = 0; i <=5; i++) {
            squares.add(i);
        }

        System.out.println(new ObjectAnalyzer().toString(squares));
    }

    private static void example3() throws ReflectiveOperationException {
        objectAnalyzer();
    }

    public static void main(String[] args) throws ReflectiveOperationException{
        //example1();

        //example3();
    }
}


class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();
    public String toString(Object obj) throws ReflectiveOperationException {
        if (obj == null) return "null";

        if (visited.contains(obj)) return "...";

        visited.add(obj);
        Class cl = obj.getClass();
        if (cl == String.class) return (String) obj;

        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) r += ", ";
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            return r + "}";
        }

        String r = cl.getName();
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);

            for (Field f : fields) {
                if (!r.endsWith("[")) r += ", ";
                {
                    r += f.getName();
                    r += "=";
                }
                Class t = f.getType();
                Object val = f.get(obj);
                if (t.isPrimitive()) r += val;
                else r += val.toString();
            }
            r += "]";
            cl = cl.getSuperclass();
        }
        while (cl != null);

        return r;
    }
}