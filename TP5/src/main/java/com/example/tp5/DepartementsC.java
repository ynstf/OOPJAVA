package com.example.tp5;

import com.example.tp5.models.Departement;
import com.example.tp5.services.IMetier;
import com.example.tp5.services.MetierImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class DepartementsC {

    @FXML
    private TextField txtSearch;

    @FXML
    private TableView<Departement> tblProfessors;

    @FXML
    private TableColumn<Departement, Integer> colId;

    @FXML
    private TableColumn<Departement, String> colName;

    @FXML
    private Button handleAdd;

    @FXML
    private Button handleUpdate;

    @FXML
    private Button handleDelete;

    private final IMetier metier = new MetierImpl(); // Service instance
    private ObservableList<Departement> departementList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Link TableView columns to Departement properties
        colId.setCellValueFactory(cellData -> cellData.getValue().idDepratProperty().asObject());
        colName.setCellValueFactory(cellData -> cellData.getValue().nomProperty());

        // Load initial data into the table
        loadDepartments();
    }

    private void loadDepartments() {
        List<Departement> departments = metier.getAllDepartements(); // Fetch from the database
        departementList.setAll(departments);
        tblProfessors.setItems(departementList);
    }

    @FXML
    public void handleSearch() {
        String keyword = txtSearch.getText().trim();
        if (!keyword.isEmpty()) {
            List<Departement> filteredList = metier.searchDepartments(keyword);
            departementList.setAll(filteredList);
        } else {
            loadDepartments();
        }
        tblProfessors.setItems(departementList);
    }

    @FXML
    public void handleAdd() {
        try {
            // Load the AddDepartmentDialog.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DeptComposants/AddDepartmentDialog.fxml"));
            Scene dialogScene = new Scene(loader.load());

            // Create a new Stage (popup)
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Department");
            dialogStage.setScene(dialogScene);

            // Show the dialog
            dialogStage.showAndWait(); // Wait for the dialog to close before continuing

            // Reload departments after adding the new one
            loadDepartments();

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Could not open the dialog.");
        }
    }


    @FXML
    public void handleUpdate() {
        Departement selected = tblProfessors.getSelectionModel().getSelectedItem();

        if (selected != null) {
            // Open the Update window and pre-fill the form
            try {
                // Load the update dialog FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("DeptComposants/UpdateDepartmentDialog.fxml"));
                Parent root = loader.load();

                // Get the controller of the dialog and set the selected department data
                UpdateDepartmentDialogController controller = loader.getController();
                controller.setDepartmentData(selected);

                // Create and show the dialog
                Scene dialogScene = new Scene(root);
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Update Department");
                dialogStage.setScene(dialogScene);
                dialogStage.showAndWait();

                // Reload the table after updating
                loadDepartments();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showAlert(AlertType.WARNING, "No Selection", "Please select a department to update.");
        }
    }


    @FXML
    public void handleDelete() {
        Departement selected = tblProfessors.getSelectionModel().getSelectedItem();
        if (selected != null) {
            metier.deleteDepartement(selected.getIdDeprat());
            loadDepartments();
        } else {
            showAlert(AlertType.WARNING, "No Selection", "Please select a department to delete.");
        }
    }


    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
