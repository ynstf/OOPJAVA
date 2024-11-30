package com.example.tp5;

import com.example.tp5.models.Departement;
import com.example.tp5.models.Professeur;
import com.example.tp5.services.IMetier;
import com.example.tp5.services.MetierImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ProfessorsC {

    @FXML
    private TextField txtSearch;

    @FXML
    private TableView<Professeur> tblProfessors;

    @FXML
    private TableColumn<Professeur, Integer> colId;

    @FXML
    private TableColumn<Professeur, String> colName;

    @FXML
    private TableColumn<Professeur, String> colLName;

    @FXML
    private TableColumn<Professeur, String> colAdress;

    @FXML
    private TableColumn<Professeur, String> colTele;

    @FXML
    private TableColumn<Professeur, String> colEmail;

    private final IMetier metier = new MetierImpl(); // Service instance
    private ObservableList<Professeur> professorList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Link TableView columns to Professeur properties
        colId.setCellValueFactory(cellData -> cellData.getValue().idProfProperty().asObject());
        colName.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        colLName.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        colAdress.setCellValueFactory(cellData -> cellData.getValue().adresseProperty());
        colTele.setCellValueFactory(cellData -> cellData.getValue().telephoneProperty());
        colEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        // Load initial data into the table
        loadProfessors();
    }

    private void loadProfessors() {
        List<Professeur> professors = metier.getAllProfesseurs(); // Fetch data from the database
        professorList.setAll(professors);
        tblProfessors.setItems(professorList);
    }

    @FXML
    public void handleSearch() {
        String keyword = txtSearch.getText().trim();
        if (!keyword.isEmpty()) {
            List<Professeur> filteredList = metier.searchProfesseurs(keyword);
            professorList.setAll(filteredList);
        } else {
            loadProfessors();
        }
        tblProfessors.setItems(professorList);
    }


    @FXML
    public void handleAdd() {
        try {
            // Load the AddDepartmentDialog.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfComposants/AddProfessorDialog.fxml"));
            Scene dialogScene = new Scene(loader.load());

            // Create a new Stage (popup)
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Profrssor");
            dialogStage.setScene(dialogScene);

            // Show the dialog
            dialogStage.showAndWait(); // Wait for the dialog to close before continuing

            // Reload departments after adding the new one
            loadProfessors();

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Could not open the dialog.");
        }
    }



    @FXML
    public void handleUpdate() {
        Professeur selected = tblProfessors.getSelectionModel().getSelectedItem();

        if (selected != null) {
            // Open the Update window and pre-fill the form
            try {
                // Load the update dialog FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfComposants/UpdateProfessorDialog.fxml"));
                Parent root = loader.load();

                // Get the controller of the dialog and set the selected department data
                UpdateProfessorDialogController controller = loader.getController();
                controller.setProfesseurData(selected);

                // Create and show the dialog
                Scene dialogScene = new Scene(root);
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Update Professor");
                dialogStage.setScene(dialogScene);
                dialogStage.showAndWait();

                // Reload the table after updating
                loadProfessors();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showAlert(AlertType.WARNING, "No Selection", "Please select a Professor to update.");
        }
    }


    @FXML
    public void handleDelete() {
        Professeur selected = tblProfessors.getSelectionModel().getSelectedItem();
        if (selected != null) {
            metier.deleteProfesseur(selected.getIdProf());
            loadProfessors();
        } else {
            showAlert(AlertType.WARNING, "No Selection", "Please select a Professor to delete.");
        }
    }


    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

