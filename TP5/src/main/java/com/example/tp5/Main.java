package com.example.tp5;

import com.example.tp5.database.SingletonConnexionDB;
import com.example.tp5.models.Departement;
import com.example.tp5.models.MetierImpl;
import com.example.tp5.models.Professeur;
import com.example.tp5.services.IMetier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IMetier metier = new MetierImpl();

        // Example: Add a new department
        Departement dept = new Departement(0, "Computer Science");
        metier.addDepartement(dept);

        // Example: Retrieve all departments
        List<Departement> departements = metier.getAllDepartements();
        departements.forEach(System.out::println);

        // Example: Add a new professor
        Professeur prof = new Professeur(0, "John", "Doe", "CIN123", "123 Street", "123456789", "john.doe@example.com", new java.util.Date(), 1);
        metier.addProfesseur(prof);

        // Example: Retrieve all professors
        List<Professeur> professeurs = metier.getAllProfesseurs();
        professeurs.forEach(System.out::println);

        // Example: Search for professors
        List<Professeur> searchResults = metier.searchProfesseurs("John");
        searchResults.forEach(System.out::println);
    }
}
