package com.example.tp5.models;

import javafx.beans.property.*;

public class Departement {

    private IntegerProperty idDeprat;
    private StringProperty nom;

    // Constructor
    public Departement(int idDeprat, String nom) {
        this.idDeprat = new SimpleIntegerProperty(idDeprat);
        this.nom = new SimpleStringProperty(nom);
    }

    public Departement() {

    }

    // Getters and Setters
    public int getIdDeprat() {
        return idDeprat.get();
    }

    public void setIdDeprat(int idDeprat) {
        this.idDeprat.set(idDeprat);
    }

    public IntegerProperty idDepratProperty() {
        return idDeprat;
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public StringProperty nomProperty() {
        return nom;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "idDeprat=" + idDeprat +
                ", nom='" + nom + '\'' +
                '}';
    }



}
