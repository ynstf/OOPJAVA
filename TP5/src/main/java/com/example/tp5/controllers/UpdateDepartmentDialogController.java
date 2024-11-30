package com.example.tp5.controllers;

import com.example.tp5.models.Departement;
import com.example.tp5.services.IMetier;
import com.example.tp5.services.MetierImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateDepartmentDialogController {

    @FXML
    private TextField txtDepartmentName;

    private Departement departmentToUpdate;
    private IMetier metier = new MetierImpl(); // Use your service to interact with the database

    // Set the selected department data into the form
    public void setDepartmentData(Departement dept) {
        departmentToUpdate = dept;
        txtDepartmentName.setText(dept.getNom());
    }

    // Handle the update logic
    @FXML
    private void handleUpdate() {
        // Get the updated department name from the TextField
        String updatedName = txtDepartmentName.getText();

        if (updatedName.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Invalid Input", "Please provide a department name.");
            return;
        }

        // Update the department object with the new data
        departmentToUpdate.setNom(updatedName);

        // Update the department in the database
        metier.updateDepartement(departmentToUpdate);

        // Close the dialog (after update)
        Stage stage = (Stage) txtDepartmentName.getScene().getWindow();
        stage.close();
    }

    // Handle cancel action (close the dialog)
    @FXML
    private void handleCancel() {
        Stage stage = (Stage) txtDepartmentName.getScene().getWindow();
        stage.close();
    }

    // Helper function to show alerts
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
