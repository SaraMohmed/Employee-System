package org.example.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String DB_NAME = "employees";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3307;

    private static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s?useSSL=false&allowPublicKeyRetrieval=true",HOST,PORT,DB_NAME),USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
