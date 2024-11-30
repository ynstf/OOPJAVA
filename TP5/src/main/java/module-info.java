module com.example.tp5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tp5 to javafx.fxml;
    exports com.example.tp5;
    exports com.example.tp5.application;
    opens com.example.tp5.application to javafx.fxml;

    opens com.example.tp5.models to javafx.base;

}