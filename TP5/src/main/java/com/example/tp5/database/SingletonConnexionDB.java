package com.example.tp5.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SingletonConnexionDB {
    private static Connection connection;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/university";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private SingletonConnexionDB() {}

    public static Connection getConnexion() {
        if (connection == null || isConnectionClosed()) {
            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("Connection successful");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error connecting to the database: " + e.getMessage());
            }
        }
        return connection;
    }

    private static boolean isConnectionClosed() {
        try {
            return connection == null || connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void closeConnexion() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
