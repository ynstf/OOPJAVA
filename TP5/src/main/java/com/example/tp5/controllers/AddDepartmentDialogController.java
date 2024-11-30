package com.example.tp5.controllers;

import com.example.tp5.models.Departement;
import com.example.tp5.services.IMetier;
import com.example.tp5.services.MetierImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddDepartmentDialogController {

    @FXML
    private TextField txtDepartmentName;

    private final IMetier metier = new MetierImpl();

    @FXML
    public void handleAdd() {
        // Get the department name from the TextField
        String departmentName = txtDepartmentName.getText().trim();

        // Check if the department name is not empty
        if (!departmentName.isEmpty()) {
            // Create a new Departement with the user input
            Departement newDept = new Departement(0, departmentName);

            // Add the department to the database
            metier.addDepartement(newDept);

            // Close the dialog after adding the department
            Stage stage = (Stage) txtDepartmentName.getScene().getWindow();
            stage.close();

            // Reload departments in the main window (call method from parent window)
            // Assuming the parent controller has a method to reload departments
            // You can pass a reference to the main controller to reload the departments after adding
        } else {
            showAlert(Alert.AlertType.WARNING, "Invalid Input", "Please enter a department name.");
        }
    }

    @FXML
    public void handleCancel() {
        // Close the dialog without saving
        Stage stage = (Stage) txtDepartmentName.getScene().getWindow();
        stage.close();
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}