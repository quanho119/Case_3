package org.example.hotelmanager.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public DatabaseConnect() {}

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Use the new driver class name
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connect database successfully");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}