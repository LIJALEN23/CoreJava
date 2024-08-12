package com.corejava.exception;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class NoFileExceptionDemo extends IOException {
    public NoFileExceptionDemo() {};

    public NoFileExceptionDemo(String msg) {
        super(msg);
    }
}

class Main {
    public static void main(String[] args) throws NoFileExceptionDemo {
        try {
            Scanner in = new Scanner(Path.of("C:\\Users\\JORDAN\\Desktop\\Hello.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new NoFileExceptionDemo("No such a file!");
        }

    }
}