package com.example.reto.controller;

import com.example.reto.model.Administrador;
import com.example.reto.service.AdministradorService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class GestionAdministradoresController {

    @FXML private TableView<Administrador> tablaAdministradores;
    @FXML private TableColumn<Administrador, String> colNombre;
    @FXML private TableColumn<Administrador, String> colEmail;
    @FXML private TableColumn<Administrador, String> colTelefono;

    @FXML private TextField nombreField;
    @FXML private TextField emailField;
    @FXML private TextField telefonoField;

    private final ObservableList<Administrador> listaAdministradores = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        colEmail.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getEmail()));
        colTelefono.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTelefono()));

        tablaAdministradores.setItems(listaAdministradores);

        tablaAdministradores.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> cargarDatos(newVal));

        cargarAdministradores();
    }

    private void cargarAdministradores() {
        try {
            listaAdministradores.setAll(AdministradorService.getAllAdministradores());
        } catch (Exception e) {
            mostrarAlerta("Error al cargar administradores: " + e.getMessage());
        }
    }

    private void cargarDatos(Administrador administrador) {
        if (administrador != null) {
            nombreField.setText(administrador.getNombre());
            emailField.setText(administrador.getEmail());
            telefonoField.setText(administrador.getTelefono());
        }
    }

    private boolean validarCampos() {
        String nombre = nombreField.getText().trim();
        String email = emailField.getText().trim();
        String telefono = telefonoField.getText().trim();

        if (nombre.isEmpty() || email.isEmpty() || telefono.isEmpty()) {
            mostrarAlerta("Todos los campos son obligatorios.");
            return false;
        }

        if (!email.contains("@") || !email.contains(".")) {
            mostrarAlerta("Email no válido.");
            return false;
        }

        if (!telefono.matches("\\d{9}")) {
            mostrarAlerta("El teléfono debe tener 9 dígitos numéricos.");
            return false;
        }

        return true;
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Validación");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    private void handleAnadir() {
        if (!validarCampos()) return;

        Administrador nuevo = new Administrador(null, nombreField.getText(), emailField.getText(), telefonoField.getText());
        try {
            AdministradorService.addAdministrador(nuevo);
            cargarAdministradores();
            limpiarCampos();
        } catch (Exception e) {
            mostrarAlerta("Error al añadir administrador: " + e.getMessage());
        }
    }

    @FXML
    private void handleEditar() {
        Administrador seleccionado = tablaAdministradores.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            if (!validarCampos()) return;

            seleccionado.setNombre(nombreField.getText());
            seleccionado.setEmail(emailField.getText());
            seleccionado.setTelefono(telefonoField.getText());

            try {
                AdministradorService.updateAdministrador(seleccionado);
                cargarAdministradores();
                limpiarCampos();
            } catch (Exception e) {
                mostrarAlerta("Error al editar administrador: " + e.getMessage());
            }
        } else {
            mostrarAlerta("Selecciona un administrador para editar.");
        }
    }

    @FXML
    private void handleEliminar() {
        Administrador seleccionado = tablaAdministradores.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            try {
                AdministradorService.deleteAdministrador(seleccionado.getId());
                cargarAdministradores();
                limpiarCampos();
            } catch (Exception e) {
                mostrarAlerta("Error al eliminar administrador: " + e.getMessage());
            }
        } else {
            mostrarAlerta("Selecciona un administrador para eliminar.");
        }
    }

    @FXML
    private void handleLimpiar() {
        limpiarCampos();
    }

    private void limpiarCampos() {
        nombreField.clear();
        emailField.clear();
        telefonoField.clear();
        tablaAdministradores.getSelectionModel().clearSelection();
    }

    @FXML
    private void handleVolver() {
        Stage stage = (Stage) nombreField.getScene().getWindow();
        stage.close();
    }
}
