package com.example.tp5.controllers;

import com.example.tp5.models.Departement;
import com.example.tp5.models.Professeur;
import com.example.tp5.services.IMetier;
import com.example.tp5.services.MetierImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class AddProfessorDialogController {

    private final IMetier metier = new MetierImpl();

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

    @FXML
    public void initialize() {
        // Fetch all departments from the database
        List<Departement> departments = metier.getAllDepartements();

        // Populate ComboBox with department names
        departmentComboBox.getItems().addAll(departments);

        // Optional: Set a cell factory to display department names in the dropdown
        departmentComboBox.setCellFactory(param -> new ListCell<Departement>() {
            @Override
            protected void updateItem(Departement item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNom());
            }
        });

        // Set the display text for the selected department
        departmentComboBox.setButtonCell(new ListCell<Departement>() {
            @Override
            protected void updateItem(Departement item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNom());
            }
        });
    }

    @FXML
    public void handleAdd() {
        String professorName = txtprofessorName.getText().trim();
        String professorLName = txtprofessorLName.getText().trim();
        String professorCin = txtprofessorCin.getText().trim();
        String professorAddress = txtprofessorAddress.getText().trim();
        String professorTele = txtprofessorTele.getText().trim();
        String professorEmail = txtprofessorEmail.getText().trim();
        LocalDate professorDate = txtprofessorDate.getValue();
        Departement selectedDepartment = departmentComboBox.getValue(); // Get the selected department

        if (professorName.isEmpty() || selectedDepartment == null) {
            showAlert(Alert.AlertType.WARNING, "Invalid Input", "Please fill in all required fields.");
            return;
        }

        Date date = Date.from(professorDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Professeur newProf = new Professeur(0, professorName, professorLName, professorCin, professorAddress,
                professorTele, professorEmail, date, selectedDepartment.getIdDeprat());

        metier.addProfesseur(newProf);

        Stage stage = (Stage) txtprofessorName.getScene().getWindow();
        stage.close();
    }


    @FXML
    public void handleCancel() {
        // Close the dialog without saving
        Stage stage = (Stage) txtprofessorName.getScene().getWindow();
        stage.close();
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}