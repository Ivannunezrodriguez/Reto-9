module com.example.reto {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;

    requires java.sql;
    requires java.rmi;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    // Abre el paquete principal para FXML
    opens com.example.reto to javafx.fxml;
    // Exporta el paquete principal
    exports com.example.reto;

    // Abre el paquete de controladores para FXML
    opens com.example.reto.controller to javafx.fxml;
    // Exporta el paquete de controladores
    exports com.example.reto.controller;
    opens com.example.reto.model to com.fasterxml.jackson.databind;
}
