package com.example.tp5.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexionDB {

    // Step 1: Declare the single instance of the Connection
    private static Connection connection;

    // Step 2: Declare the database URL, username, and password (these can be constants or externalized)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/university";
    private static final String DB_USER = "root";  // Replace with your MySQL username
    private static final String DB_PASSWORD = "";  // Replace with your MySQL password

    // Step 3: Private constructor to prevent instantiation
    private SingletonConnexionDB() {}

    // Step 4: Provide a method to get the connection (the Singleton pattern)
    public static Connection getConnexion() {
        if (connection == null) {
            try {
                // Initialize the connection if it is not already created
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("Connection successful");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error connecting to the database: " + e.getMessage());
            }
        }
        return connection;  // Return the existing connection if already created
    }

    // Step 5: Close the connection (optional utility method)
    public static void closeConnexion() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;  // Ensure the connection is set to null after closing
                System.out.println("Connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
