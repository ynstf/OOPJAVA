package com.example.tp5.services;

import com.example.tp5.models.Departement;
import com.example.tp5.models.Professeur;

import java.util.List;

public interface IMetier {

    // Methods for managing professors
    List<Professeur> getAllProfesseurs(); // Retrieve all professors
    Professeur getProfesseurById(int id); // Retrieve a professor by their ID
    void addProfesseur(Professeur prof);  // Add a new professor
    void updateProfesseur(Professeur prof); // Update an existing professor
    void deleteProfesseur(int id);        // Delete a professor by their ID
    List<Professeur> searchProfesseurs(String keyword); // Search professors by keyword

    // Methods for managing departments
    List<Departement> getAllDepartements(); // Retrieve all departments
    Departement getDepartementById(int id); // Retrieve a department by their ID
    void addDepartement(Departement dept);  // Add a new department
    void updateDepartement(Departement dept); // Update an existing department
    void deleteDepartement(int id);          // Delete a department by their ID
    List<Departement> searchDepartments(String keyword);
    List<Professeur> getProfesseursByDepartement(int idDepartement); // Get all professors in a department
}
