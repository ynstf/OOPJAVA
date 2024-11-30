package com.example.tp5;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class MainC {

    @FXML
    private VBox professorsTabContent;

    @FXML
    private VBox departementsTabContent;

    @FXML
    public void initialize() {
        try {
            // Load ProfessorsView.fxml
            VBox professorsView = FXMLLoader.load(getClass().getResource("ProfessorsView.fxml"));
            professorsTabContent.getChildren().setAll(professorsView);

            // Load DepartementsView.fxml
            VBox departementsView = FXMLLoader.load(getClass().getResource("DepartementsView.fxml"));
            departementsTabContent.getChildren().setAll(departementsView);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
