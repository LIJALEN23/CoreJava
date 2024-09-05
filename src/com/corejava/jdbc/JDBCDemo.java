package com.corejava.jdbc;

import java.sql.*;

public class JDBCDemo {
    public static Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/corejava";
        String username = "root";
        String password = "lijalen";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            for (Throwable t : e) t.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void insert() throws SQLException {
        try (Connection conn = getConnection();
             Statement stat = conn.createStatement()) {

            stat.executeUpdate("INSERT INTO webinfo VALUES (5, 'luogu', 'www.luogu.com.cn')");
            stat.executeUpdate("INSERT INTO webinfo VALUES (6, 'pku', 'www.pku.edu.cn')");

        } catch (SQLException e) {
            for (Throwable t : e) t.printStackTrace();
        }
    }

    public static void query() throws SQLException {
        try (Connection conn = getConnection();
             Statement stat = conn.createStatement()) {

            try (ResultSet rst = stat.executeQuery("SELECT * FROM webinfo")) {
                while (rst.next()) {
                    int num = rst.getInt(1);
                    String name = rst.getString(2);
                    String url = rst.getString(3);

                    System.out.printf("%-1d | %-10s | %-20s\n", num, name, url);
                    //System.out.println(num + " | " + name + " | " + url);
                }
            }

        } catch (SQLException e) {
            for (Throwable t : e) t.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            //insert();
            query();
        } catch (SQLException ex) {
            for (Throwable t : ex)  t.printStackTrace();
        }
    }
}
