package com.example.reto.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    // Clase interna simple para representar usuarios
    public static class Usuario {
        private String username;
        private String password;
        private String role; // "empresa" o "admin"

        public Usuario(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public String getUsername() { return username; }
        public String getPassword() { return password; }
        public String getRole() { return role; }
    }

    // "Base de datos" de usuarios simulada
    private List<Usuario> usuarios = new ArrayList<>();

    @FXML
    public void initialize() {
        // Definimos usuarios válidos
        usuarios.add(new Usuario("empresa1", "1234", "empresa"));
        usuarios.add(new Usuario("admin1", "admin", "admin"));
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Buscar el usuario en la lista
        Usuario usuarioValido = usuarios.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (usuarioValido != null) {
            // Login exitoso
            errorLabel.setText("");
            if ("empresa".equals(usuarioValido.getRole())) {
                abrirVista("/com/example/reto/EmpresaVacanteView.fxml", "Panel Empresa");
            } else if ("admin".equals(usuarioValido.getRole())) {
                abrirVista("/com/example/reto/AdminView.fxml", "Panel Administrador");
            }
        } else {
            // Login fallido
            errorLabel.setText("Usuario o contraseña incorrectos");
        }
    }

    private void abrirVista(String rutaFXML, String tituloVentana) {
        try {
            // Cargar la nueva vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();

            // Obtener el stage actual
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(tituloVentana);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
