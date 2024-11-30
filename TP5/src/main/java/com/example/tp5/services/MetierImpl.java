package com.example.tp5.services;

import com.example.tp5.database.SingletonConnexionDB;
import com.example.tp5.models.Departement;
import com.example.tp5.models.Professeur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements IMetier {
    private Connection conn;

    public MetierImpl() {
        conn = SingletonConnexionDB.getConnexion();  // Assuming SingletonConnexionDB is correctly set up
    }

    // ********** Methods for Managing Professors **********

    @Override
    public List<Professeur> getAllProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        String query = "SELECT * FROM professeur";

        try (Connection conn = SingletonConnexionDB.getConnexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Professeur prof = new Professeur(
                        rs.getInt("id_prof"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("cin"),
                        rs.getString("adresse"),
                        rs.getString("telephone"),
                        rs.getString("email"),
                        rs.getDate("date_recrutement"),
                        rs.getInt("id_deprat")
                );
                professeurs.add(prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    // New method to search departments
    @Override
    public List<Departement> searchDepartments(String keyword) {
        List<Departement> departements = new ArrayList<>();
        String query = "SELECT * FROM departement WHERE nom LIKE ?";
        try (Connection conn = SingletonConnexionDB.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + keyword + "%");  // Use keyword for searching
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Departement dept = new Departement(
                        rs.getInt("id_deprat"),
                        rs.getString("nom")
                );
                departements.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }

    @Override
    public Professeur getProfesseurById(int id) {
        String query = "SELECT * FROM professeur WHERE id_prof = ?";
        Professeur prof = null;

        try (Connection conn = SingletonConnexionDB.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                prof = new Professeur(
                        rs.getInt("id_prof"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("cin"),
                        rs.getString("adresse"),
                        rs.getString("telephone"),
                        rs.getString("email"),
                        rs.getDate("date_recrutement"),
                        rs.getInt("id_deprat")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prof;
    }

    @Override
    public void addProfesseur(Professeur prof) {
        String query = "INSERT INTO professeur (nom, prenom, cin, adresse, telephone, email, date_recrutement, id_deprat) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = SingletonConnexionDB.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, prof.getNom());
            pstmt.setString(2, prof.getPrenom());
            pstmt.setString(3, prof.getCin());
            pstmt.setString(4, prof.getAdresse());
            pstmt.setString(5, prof.getTelephone());
            pstmt.setString(6, prof.getEmail());
            pstmt.setDate(7, new java.sql.Date(prof.getDateRecrutement().getTime()));
            pstmt.setInt(8, prof.getIdDepart());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProfesseur(Professeur prof) {
        String query = "UPDATE professeur SET nom = ?, prenom = ?, cin = ?, adresse = ?, telephone = ?, email = ?, date_recrutement = ?, id_deprat = ? WHERE id_prof = ?";

        try (Connection conn = SingletonConnexionDB.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, prof.getNom());
            pstmt.setString(2, prof.getPrenom());
            pstmt.setString(3, prof.getCin());
            pstmt.setString(4, prof.getAdresse());
            pstmt.setString(5, prof.getTelephone());
            pstmt.setString(6, prof.getEmail());
            pstmt.setDate(7, new java.sql.Date(prof.getDateRecrutement().getTime()));
            pstmt.setInt(8, prof.getIdDepart());
            pstmt.setInt(9, prof.getIdProf());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProfesseur(int id) {
        String query = "DELETE FROM professeur WHERE id_prof = ?";

        try (Connection conn = SingletonConnexionDB.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Professeur> searchProfesseurs(String keyword) {
        List<Professeur> professeurs = new ArrayList<>();
        String query = "SELECT * FROM professeur WHERE nom LIKE ? OR prenom LIKE ?";

        try (Connection conn = SingletonConnexionDB.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Professeur prof = new Professeur(
                        rs.getInt("id_prof"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("cin"),
                        rs.getString("adresse"),
                        rs.getString("telephone"),
                        rs.getString("email"),
                        rs.getDate("date_recrutement"),
                        rs.getInt("id_deprat")
                );
                professeurs.add(prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    // ********** Methods for Managing Departments **********

    @Override
    public List<Departement> getAllDepartements() {
        List<Departement> departements = new ArrayList<>();
        String query = "SELECT * FROM departement";

        try (Connection conn = SingletonConnexionDB.getConnexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Departement dept = new Departement(
                        rs.getInt("id_deprat"),
                        rs.getString("nom")
                );
                departements.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }

    @Override
    public Departement getDepartementById(int id) {
        String query = "SELECT * FROM departement WHERE id_deprat = ?";
        Departement dept = null;

        try (Connection conn = SingletonConnexionDB.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                dept = new Departement(
                        rs.getInt("id_deprat"),
                        rs.getString("nom")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }

    @Override
    public void addDepartement(Departement dept) {
        String query = "INSERT INTO departement (nom) VALUES (?)";

        try (Connection conn = SingletonConnexionDB.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, dept.getNom());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDepartement(Departement dept) {
        String query = "UPDATE departement SET nom = ? WHERE id_deprat = ?";

        try (Connection conn = SingletonConnexionDB.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, dept.getNom());
            pstmt.setInt(2, dept.getIdDeprat());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDepartement(int id) {
        String query = "DELETE FROM departement WHERE id_deprat = ?";

        try (Connection conn = SingletonConnexionDB.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Professeur> getProfesseursByDepartement(int idDepartement) {
        List<Professeur> professeurs = new ArrayList<>();
        String query = "SELECT * FROM professeur WHERE id_deprat = ?";

        try (Connection conn = SingletonConnexionDB.getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idDepartement);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Professeur prof = new Professeur(
                        rs.getInt("id_prof"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("cin"),
                        rs.getString("adresse"),
                        rs.getString("telephone"),
                        rs.getString("email"),
                        rs.getDate("date_recrutement"),
                        rs.getInt("id_deprat")
                );
                professeurs.add(prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }
}



