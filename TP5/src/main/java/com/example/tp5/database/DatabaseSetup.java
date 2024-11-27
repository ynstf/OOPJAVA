package com.example.tp5.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseSetup {
    public static void main(String[] args) {
        // JDBC URL, username, and password
        String url = "jdbc:mysql://localhost:3306/university?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "";

        // SQL queries
        String createDatabase = "CREATE DATABASE IF NOT EXISTS university;";
        String createDepartementTable = """
                CREATE TABLE IF NOT EXISTS Departement (
                    id_deprat INT AUTO_INCREMENT PRIMARY KEY,
                    nom VARCHAR(255) NOT NULL
                );
                """;
        String createProfesseurTable = """
                CREATE TABLE IF NOT EXISTS Professeur (
                    id_prof INT AUTO_INCREMENT PRIMARY KEY,
                    nom VARCHAR(255) NOT NULL,
                    prenom VARCHAR(255) NOT NULL,
                    cin VARCHAR(20) UNIQUE NOT NULL,
                    adresse VARCHAR(255),
                    telephone VARCHAR(20),
                    email VARCHAR(255) UNIQUE NOT NULL,
                    date_recrutement DATE NOT NULL,
                    id_deprat INT,
                    FOREIGN KEY (id_deprat) REFERENCES Departement(id_deprat)
                    ON DELETE SET NULL
                    ON UPDATE CASCADE
                );
                """;

        try {
            // Explicitly load the driver (optional for JDBC 4.0+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            try (Connection connection = DriverManager.getConnection(url, username, password);
                 Statement statement = connection.createStatement()) {

                // Create the database
                statement.executeUpdate(createDatabase);
                System.out.println("Database created or already exists.");

                // Create the tables
                statement.executeUpdate(createDepartementTable);
                System.out.println("Departement table created or already exists.");

                statement.executeUpdate(createProfesseurTable);
                System.out.println("Professeur table created or already exists.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
    }
}
