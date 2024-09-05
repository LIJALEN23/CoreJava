package com.corejava.jdbc;

import java.io.IOException;
import java.sql.*;

public class JDBCPreviewDemo {

    public static void runTest() throws SQLException, ClassNotFoundException {
        try (Connection conn = getConnection();
                Statement stat = conn.createStatement()) {
            stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
            stat.executeUpdate("INSERT INTO Greetings VALUES ('Hello, world')");

            try (ResultSet rst = stat.executeQuery("SELECT * FROM Greetings")) {
                if (rst.next()) {
                    System.out.println(rst.getString(1));
                }
                stat.executeUpdate("DROP TABLE Greetings");
            }
        }
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/corejava";
        String username = "root";
        String password = "lijalen";

        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        try {
        runTest();
        } catch (SQLException ex) {
            for (Throwable t : ex)  t.printStackTrace();
        }
    }
}
