package com.corejava.basicprogramming;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.Console;

public class IODemo {

    private static void example1() {
        Scanner in = new Scanner(System.in);

        System.out.print("I will read a word:");
        String nextWord = in.next();
        System.out.println("\n" + nextWord);
        System.out.print("I will read a line:");
        String nextLine = in.nextLine();
        System.out.println("\n" + nextLine);

        in.close();
    }

    private static void example2() {
        Console cons = System.console();
        char[] password = cons.readPassword("Password:");
    }

    private static void example3() throws IOException {
        Scanner in = new Scanner(Path.of("C:\\Users\\JORDAN\\Desktop\\Hello.txt"), StandardCharsets.UTF_8);
        System.out.println(in.nextLine());
        in.close();

        PrintWriter out = new PrintWriter("C:\\Users\\JORDAN\\Desktop\\Hi.txt", StandardCharsets.UTF_8);

        out.println("Wuling, I will come back!");
        out.close();
    }

    public static void main(String[] args) throws IOException {
        //example1();
        //example2();
        example3();
    }
}
