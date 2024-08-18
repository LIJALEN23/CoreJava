package com.corejava.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TxtIODemo {

    private static void writeData(Book[] books, PrintWriter out) throws IOException {
        out.println(books.length);

        for (Book b : books) {
            writeBook(out, b);
        }
    }

    private static Book[] readData(Scanner in) throws IOException {
        int length = in.nextInt();
        in.nextLine();

        var books = new Book[length];

        for (int i = 0; i < length; i++) {
            books[i] = readBook(in);
        }

        return books;
    }

    private static Book readBook(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        String author = tokens[1];

        return new Book(name, author);
    }

    private static void writeBook(PrintWriter out, Book book) {
        out.println(book.name + "|" + book.author);
    }

    private static void example1() throws IOException {
        var books = new Book[2];

        books[0] = new Book("红楼梦", "曹雪芹");
        books[1] = new Book("三国演义", "罗贯中");

        try (var out = new PrintWriter("books.dat", StandardCharsets.UTF_8)) {
            writeData(books, out);
        }

        try (var in = new Scanner(new FileInputStream("books.dat"), StandardCharsets.UTF_8)) {
            Book[] newBooks = readData(in);

            for (Book b : newBooks) {
                System.out.println(b);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        example1();
    }
}

class Book {
    public static final long RECORD_SIZE = 64;
    public static final long NAME_SIZE = 32;
    public static final long AUTHOR_SIZE = 32;

    public StringBuilder name;
    public StringBuilder author;

    public Book(String name, String author) {
        this.name = new StringBuilder(name);
        this.author = new StringBuilder(author);
    }


    @Override
    public String toString() {
        return "《" + this.name + "》 : " + this.author;
    }
}