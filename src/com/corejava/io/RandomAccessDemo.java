//package com.corejava.io;
//
//import java.io.*;
//
//public class RandomAccessDemo {
//
//    private static Book readData(DataInput in) {
//        //StringBuilder name = DataIO.readFixedString(Book.NAME_SIZE, in);
//
//
//        return null;
//    }
//
//    private static void writeData(DataOutput out, Book book) {
//
//    }
//
//    public static void example1() throws IOException {
//        var books = new Book[2];
//        books[0] = new Book("红楼梦", "曹雪芹");
//        books[1] = new Book("三国演义", "罗贯中");
//
//        try (var out = new DataOutputStream(new FileOutputStream("example1.dat"))) {
//            for (Book b : books) {
//                writeData(out, b);
//            }
//        }
//
//        try (var in = new RandomAccessFile("example1.dat", "r")) {
//            int length = (int) (in.length() / Book.RECORD_SIZE);
//            var newBook = new Book[length];
//
//            for (int i = length - 1; i >= 0; i--) {
//                newBook[i] = readData(in);
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//            example1();
//    }
//}