package com.example.reto.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML private Button btnSalir; // para obtener la ventana actual

    @FXML
    private void handleEmpresas() {
        abrirVista("/com/example/reto/GestionEmpresasView.fxml", "Gestión de Empresas");
    }

    @FXML
    private void handleCategorias() {
        abrirVista("/com/example/reto/GestionCategoriasView.fxml", "Gestión de Categorías");
    }

    @FXML
    private void handleUsuarios() {
        abrirVista("/com/example/reto/GestionUsuariosView.fxml", "Gestión de Usuarios");
    }

    @FXML
    private void handleAdministradores() {
        abrirVista("/com/example/reto/GestionAdministradoresView.fxml", "Gestión de Administradores");
    }

    private void abrirVista(String rutaFXML, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(titulo);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSalir() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/reto/LoginView.fxml"));
            Parent root = loader.load();

            Stage currentStage = (Stage) btnSalir.getScene().getWindow();
            currentStage.setTitle("Login");
            currentStage.setScene(new Scene(root, 400, 300)); // Ajusta a tamaño deseado
            currentStage.setResizable(false); // Opcional si quieres que no se pueda redimensionar
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
