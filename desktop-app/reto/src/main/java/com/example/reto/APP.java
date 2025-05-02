package com.example.reto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class APP extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // Cargar el archivo FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/reto/LoginView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);  // Ajuste de tamaño a 800x600

            // Configurar la ventana
            stage.setTitle("Gestión de Vacantes");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // Manejo de excepciones si el archivo FXML no se encuentra o hay un error al cargarlo
            System.err.println("Error al cargar el archivo FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
