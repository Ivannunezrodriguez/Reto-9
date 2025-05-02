package com.example.reto.controller;

import com.example.reto.model.Categoria;
import com.example.reto.apiservice.ApiService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.List;

public class GestionCategoriasController {

    @FXML private TableView<Categoria> tablaCategorias;
    @FXML private TableColumn<Categoria, String> colNombre;
    @FXML private TableColumn<Categoria, String> colDescripcion;

    @FXML private TextField nombreField;
    @FXML private TextField descripcionField;

    private final ObservableList<Categoria> listaCategorias = FXCollections.observableArrayList();
    private final ObjectMapper mapper = new ObjectMapper();

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        colDescripcion.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDescripcion()));

        tablaCategorias.setItems(listaCategorias);
        tablaCategorias.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> cargarDatos(newVal));

        cargarCategoriasDesdeAPI();
    }

    private void cargarCategoriasDesdeAPI() {
        try {
            String json = ApiService.get("/categorias");
            List<Categoria> categorias = mapper.readValue(json, new TypeReference<>() {});
            listaCategorias.setAll(categorias);
        } catch (Exception e) {
            mostrarError("Error al cargar categorías: " + e.getMessage());
        }
    }

    private void cargarDatos(Categoria categoria) {
        if (categoria != null) {
            nombreField.setText(categoria.getNombre());
            descripcionField.setText(categoria.getDescripcion());
        }
    }

    private boolean validarCampos() {
        String nombre = nombreField.getText() != null ? nombreField.getText().trim() : "";
        String descripcion = descripcionField.getText() != null ? descripcionField.getText().trim() : "";

        if (nombre.isEmpty() || descripcion.isEmpty()) {
            mostrarError("Todos los campos son obligatorios.");
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

        Categoria nueva = new Categoria(nombreField.getText(), descripcionField.getText());
        try {
            String json = mapper.writeValueAsString(nueva);
            ApiService.post("/categorias", json);
            cargarCategoriasDesdeAPI();
            limpiarCampos();
        } catch (Exception e) {
            mostrarError("Error al añadir categoría: " + e.getMessage());
        }
    }

    @FXML
    private void handleEditar() {
        Categoria seleccionada = tablaCategorias.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            if (!validarCampos()) return;

            seleccionada.setNombre(nombreField.getText());
            seleccionada.setDescripcion(descripcionField.getText());
            try {
                String json = mapper.writeValueAsString(seleccionada);
                ApiService.put("/categorias/" + seleccionada.getId(), json);
                cargarCategoriasDesdeAPI();
                limpiarCampos();
            } catch (Exception e) {
                mostrarError("Error al editar categoría: " + e.getMessage());
            }
        } else {
            mostrarError("Selecciona una categoría para editar.");
        }
    }

    @FXML
    private void handleEliminar() {
        Categoria seleccionada = tablaCategorias.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            try {
                ApiService.delete("/categorias/" + seleccionada.getId());
                cargarCategoriasDesdeAPI();
                limpiarCampos();
            } catch (Exception e) {
                mostrarError("Error al eliminar categoría: " + e.getMessage());
            }
        } else {
            mostrarError("Selecciona una categoría para eliminar.");
        }
    }

    @FXML
    private void handleLimpiar() {
        limpiarCampos();
    }

    private void limpiarCampos() {
        nombreField.clear();
        descripcionField.clear();
        tablaCategorias.getSelectionModel().clearSelection();
    }

    @FXML
    private void handleVolver() {
        Stage stage = (Stage) nombreField.getScene().getWindow();
        stage.close();
    }
}




