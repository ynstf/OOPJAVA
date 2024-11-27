package com.example.tp5;

import com.example.tp5.database.SingletonConnexionDB;
import com.example.tp5.models.Departement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Get the unique connection instance
        Connection conn = SingletonConnexionDB.getConnexion();

        try {
            // Create a statement and execute a query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Professeur");

            // Process the results
            while (rs.next()) {
                System.out.println("Professeur ID: " + rs.getInt("id_prof") + ", Nom: " + rs.getString("nom"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connection when done
            SingletonConnexionDB.closeConnexion();
        }
    }
}
