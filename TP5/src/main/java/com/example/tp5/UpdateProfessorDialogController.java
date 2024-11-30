package com.example.tp5;

import com.example.tp5.models.Departement;
import com.example.tp5.models.Professeur;
import com.example.tp5.services.IMetier;
import com.example.tp5.services.MetierImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


public class UpdateProfessorDialogController {



    private Professeur professeurToUpdate;
    private IMetier metier = new MetierImpl(); // Use your service to interact with the database

    @FXML
    private TextField txtprofessorName;
    @FXML
    private TextField txtprofessorLName;
    @FXML
    private TextField txtprofessorCin;
    @FXML
    private TextField txtprofessorAddress;
    @FXML
    private TextField txtprofessorTele;
    @FXML
    private TextField txtprofessorEmail;
    @FXML
    private DatePicker txtprofessorDate;
    @FXML
    private ComboBox<Departement> departmentComboBox;


    // Set the selected department data into the form
    public void setProfesseurData(Professeur prof) {
        professeurToUpdate = prof;
        txtprofessorName.setText(prof.getNom());
        txtprofessorLName.setText(prof.getPrenom());
        txtprofessorCin.setText(prof.getCin());
        txtprofessorAddress.setText(prof.getAdresse());
        txtprofessorTele.setText(prof.getTelephone());
        txtprofessorEmail.setText(prof.getEmail());


        if (prof.getDateRecrutement() != null) {
            // Assuming you have a java.util.Date object, like prof.getDateRecrutement()
            java.util.Date utilDate = prof.getDateRecrutement();  // This is the original java.util.Date
            // Convert it to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            LocalDate localDate = sqlDate.toLocalDate(); // Use toLocalDate() for java.sql.Date
            txtprofessorDate.setValue(localDate);
        }



        // Populate the departmentComboBox with all departments
        List<Departement> allDepartments = metier.getAllDepartements();
        ObservableList<Departement> departmentList = FXCollections.observableArrayList(allDepartments);
        departmentComboBox.setItems(departmentList);

        // Set the converter to display only the department name
        departmentComboBox.setConverter(new StringConverter<Departement>() {
            @Override
            public String toString(Departement dept) {
                return dept.getNom(); // Display only the department name
            }

            @Override
            public Departement fromString(String string) {
                return null; // You can implement this method if you need to handle user input (optional)
            }
        });
        // Find and set the professor's department as the selected item
        for (Departement dept : allDepartments) {
            if (dept.getIdDeprat() == prof.getIdDepart()) {
                departmentComboBox.setValue(dept);
                break;
            }
        }

    }

    // Handle the update logic
    @FXML
    private void handleUpdate() {
        // Get the updated department name from the TextField
        String professorName = txtprofessorName.getText().trim();
        String professorLName = txtprofessorLName.getText().trim();
        String professorCin = txtprofessorCin.getText().trim();
        String professorAddress = txtprofessorAddress.getText().trim();
        String professorTele = txtprofessorTele.getText().trim();
        String professorEmail = txtprofessorEmail.getText().trim();
        LocalDate professorDate = txtprofessorDate.getValue();
        Departement selectedDepartment = departmentComboBox.getValue(); // Get the selected department


        if (professorName.isEmpty() || selectedDepartment == null) {
            showAlert(Alert.AlertType.WARNING, "Invalid Input", "Please provide a department name.");
            return;
        }

        // Update the department object with the new data
        professeurToUpdate.setNom(professorName);
        professeurToUpdate.setPrenom(professorLName);
        professeurToUpdate.setCin(professorCin);
        professeurToUpdate.setAdresse(professorAddress);
        professeurToUpdate.setTelephone(professorTele);
        professeurToUpdate.setEmail(professorEmail);
        Date date = Date.from(professorDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        professeurToUpdate.setDateRecrutement(date);
        professeurToUpdate.setIdDepart(selectedDepartment.getIdDeprat());

        // Update the department in the database
        metier.updateProfesseur(professeurToUpdate);

        // Close the dialog (after update)
        Stage stage = (Stage) txtprofessorName.getScene().getWindow();
        stage.close();
    }

    // Handle cancel action (close the dialog)
    @FXML
    private void handleCancel() {
        Stage stage = (Stage) txtprofessorName.getScene().getWindow();
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
