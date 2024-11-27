package com.example.tp5.models;

public class Departement {
    private int idDeprat;
    private String nom;

    // Constructor
    public Departement(int idDeprat, String nom) {
        this.idDeprat = idDeprat;
        this.nom = nom;
    }

    // Default Constructor
    public Departement() {}

    // Getters and Setters
    public int getIdDeprat() {
        return idDeprat;
    }

    public void setIdDeprat(int idDeprat) {
        this.idDeprat = idDeprat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "idDeprat=" + idDeprat +
                ", nom='" + nom + '\'' +
                '}';
    }
}
