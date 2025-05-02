package com.example.reto.controller;

import com.example.reto.model.Usuario;
import com.example.reto.apiservice.ApiService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.List;

public class GestionUsuariosController {

    @FXML private TableView<Usuario> tablaUsuarios;
    @FXML private TableColumn<Usuario, String> colNombre;
    @FXML private TableColumn<Usuario, String> colEmail;
    @FXML private TableColumn<Usuario, String> colTelefono;

    @FXML private TextField nombreField;
    @FXML private TextField emailField;
    @FXML private TextField telefonoField;

    private final ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    private final ObjectMapper mapper = new ObjectMapper();

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNombre()));
        colEmail.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getEmail()));
        colTelefono.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTelefono()));

        tablaUsuarios.setItems(listaUsuarios);
        tablaUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> cargarDatos(newVal));

        cargarUsuariosDesdeAPI();
    }

    private void cargarUsuariosDesdeAPI() {
        try {
            String json = ApiService.get("/usuarios");
            List<Usuario> usuarios = mapper.readValue(json, new TypeReference<>() {});
            listaUsuarios.setAll(usuarios);
        } catch (Exception e) {
            mostrarError("Error al cargar usuarios: " + e.getMessage());
        }
    }

    private void cargarDatos(Usuario usuario) {
        if (usuario != null) {
            nombreField.setText(usuario.getNombre());
            emailField.setText(usuario.getEmail());
            telefonoField.setText(usuario.getTelefono());
        }
    }

    private boolean validarCampos() {
        if (nombreField.getText().isEmpty() || emailField.getText().isEmpty() || telefonoField.getText().isEmpty()) {
            mostrarError("Todos los campos son obligatorios.");
            return false;
        }
        if (!telefonoField.getText().matches("\\d{9}")) {
            mostrarError("El teléfono debe tener 9 dígitos.");
            return false;
        }
        if (!emailField.getText().contains("@")) {
            mostrarError("Email no válido.");
            return false;
        }
        return true;
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void handleAnadir() {
        if (!validarCampos()) return;

        Usuario nuevo = new Usuario(null, nombreField.getText(), emailField.getText(), telefonoField.getText());
        try {
            String json = mapper.writeValueAsString(nuevo);
            ApiService.post("/usuarios", json);
            cargarUsuariosDesdeAPI();
            limpiarCampos();
        } catch (Exception e) {
            mostrarError("Error al añadir usuario: " + e.getMessage());
        }
    }

    @FXML
    private void handleEditar() {
        Usuario seleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado != null && validarCampos()) {
            seleccionado.setNombre(nombreField.getText());
            seleccionado.setEmail(emailField.getText());
            seleccionado.setTelefono(telefonoField.getText());
            try {
                String json = mapper.writeValueAsString(seleccionado);
                ApiService.put("/usuarios/" + seleccionado.getId(), json);
                cargarUsuariosDesdeAPI();
                limpiarCampos();
            } catch (Exception e) {
                mostrarError("Error al editar usuario: " + e.getMessage());
            }
        }
    }

    @FXML
    private void handleEliminar() {
        Usuario seleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            try {
                ApiService.delete("/usuarios/" + seleccionado.getId());
                cargarUsuariosDesdeAPI();
                limpiarCampos();
            } catch (Exception e) {
                mostrarError("Error al eliminar usuario: " + e.getMessage());
            }
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
        tablaUsuarios.getSelectionModel().clearSelection();
    }

    @FXML
    private void handleVolver() {
        Stage stage = (Stage) nombreField.getScene().getWindow();
        stage.close();
    }
}
