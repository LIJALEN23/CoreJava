package com.corejava.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class IOPreviewDemo {

    //File类
    private static void example1() {
        String parent = "C:\\Users\\JORDAN\\Desktop";
        String child = "LastDays.md";
        File file1 = new File(parent, child);
        File file2 = new File(parent);
        File file3 = new File(file2, child);
        System.out.println(file3);

        if (file1.exists()) System.out.println("文件存在");
        System.out.println(file1.length() + " bytes");
        System.out.println(file1.getAbsolutePath());

        File[] files = new File(parent).listFiles();
        for (File f : files) {
            System.out.println(f);
        }
        System.out.println();


    }

    //InputStream、OutputStream读写字节
    private static void example2() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\JORDAN\\Desktop\\example2.txt");

        fileOut.write(98);

        fileOut.write(99);

        fileOut.close();

        FileInputStream fileIn = new FileInputStream("C:\\Users\\JORDAN\\Desktop\\example2.txt");
        byte[] bytes = new byte[50];
        bytes = fileIn.readAllBytes();
        fileIn.close();
        System.out.println(bytes);
    }

    //Reader、Writer读写Unicode
    private static void example3() throws IOException {
        FileWriter fileOut = new FileWriter("C:\\Users\\JORDAN\\Desktop\\example3.txt");
        FileReader fileIn = new FileReader("C:\\Users\\JORDAN\\Desktop\\example3.txt");

        fileOut.write("我是lijalen");
        fileOut.flush();
        char ch;
        while ((ch = (char) fileIn.read()) != (char) -1) {
            System.out.println(ch);
        }



        fileIn.close();
        fileOut.close();
    }

    //缓冲流。字节/字符Buffer
    private static void example4() throws IOException {
        File file = new File("C:\\Users\\JORDAN\\Desktop\\example4.txt");
        BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream(file));


        BufferedReader file1In = new BufferedReader(new FileReader(file));
        BufferedWriter file1out  = new BufferedWriter(new FileWriter(file));


        fileOut.close();
        fileIn.close();
        file1In.close();
        file1out.close();
    }
    public static void main(String[] args) throws IOException {
        example4();
    }
}
