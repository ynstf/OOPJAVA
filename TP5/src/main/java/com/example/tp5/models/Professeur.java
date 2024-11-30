package com.example.tp5.models;
import java.util.Date;
import javafx.beans.property.*;

public class Professeur {

    private IntegerProperty idProf;
    private StringProperty nom;
    private StringProperty prenom;
    private StringProperty cin;
    private StringProperty adresse;
    private StringProperty telephone;
    private StringProperty email;
    private ObjectProperty<Date> dateRecrutement;
    private IntegerProperty idDepart;

    // Constructor
    public Professeur(int idProf, String nom, String prenom, String cin, String adresse,
                      String telephone, String email, Date dateRecrutement, int idDepart) {
        this.idProf = new SimpleIntegerProperty(idProf);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.cin = new SimpleStringProperty(cin);
        this.adresse = new SimpleStringProperty(adresse);
        this.telephone = new SimpleStringProperty(telephone);
        this.email = new SimpleStringProperty(email);
        this.dateRecrutement = new SimpleObjectProperty<>(dateRecrutement);
        this.idDepart = new SimpleIntegerProperty(idDepart);
    }    public Professeur(int idProf, String nom, String prenom, String cin, String adresse,
                      String telephone, String email, Date dateRecrutement) {
        this.idProf = new SimpleIntegerProperty(idProf);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.cin = new SimpleStringProperty(cin);
        this.adresse = new SimpleStringProperty(adresse);
        this.telephone = new SimpleStringProperty(telephone);
        this.email = new SimpleStringProperty(email);
        this.dateRecrutement = new SimpleObjectProperty<>(dateRecrutement);
    }

    public Professeur() {

    }

    // Getters and Setters
    public int getIdProf() {
        return idProf.get();
    }
    public String getNom() {
        return nom.get();
    }
    public String getPrenom() {
        return prenom.get();
    }
    public String getCin() {
        return cin.get();
    }


    public void setIdProf(int idProf) {
        this.idProf.set(idProf);
    }

    public IntegerProperty idProfProperty() {
        return idProf;
    }



    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public StringProperty nomProperty() {
        return nom;
    }



    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public StringProperty prenomProperty() {
        return prenom;
    }



    public void setCin(String cin) {
        this.cin.set(cin);
    }

    public StringProperty cinProperty() {
        return cin;
    }

    public String getAdresse() {
        return adresse.get();
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }

    public StringProperty adresseProperty() {
        return adresse;
    }

    public String getTelephone() {
        return telephone.get();
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public Date getDateRecrutement() {
        return dateRecrutement.get();
    }

    public void setDateRecrutement(Date dateRecrutement) {
        this.dateRecrutement.set(dateRecrutement);
    }

    public ObjectProperty<Date> dateRecrutementProperty() {
        return dateRecrutement;
    }

    public int getIdDepart() {
        return idDepart.get();
    }

    public void setIdDepart(int idDepart) {
        this.idDepart.set(idDepart);
    }

    public IntegerProperty idDepartProperty() {
        return idDepart;
    }

    @Override
    public String toString() {
        return "Professeur{" +
                "idProf=" + idProf +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", dateRecrutement=" + dateRecrutement +
                ", idDepart=" + idDepart +
                '}';
    }

}
