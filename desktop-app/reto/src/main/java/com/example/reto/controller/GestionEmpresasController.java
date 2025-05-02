package com.example.reto.controller;

import com.example.reto.model.Empresa;
import com.example.reto.service.EmpresaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class GestionEmpresasController {

    @FXML private TableView<Empresa> tablaEmpresas;
    @FXML private TableColumn<Empresa, String> colNombre;
    @FXML private TableColumn<Empresa, String> colCif;
    @FXML private TableColumn<Empresa, String> colTelefono;

    @FXML private TextField nombreField;
    @FXML private TextField cifField;
    @FXML private TextField telefonoField;

    private final ObservableList<Empresa> listaEmpresas = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        colCif.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCif()));
        colTelefono.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTelefono()));

        tablaEmpresas.setItems(listaEmpresas);
        tablaEmpresas.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> cargarDatos(newVal));

        cargarEmpresasDesdeApi();
    }

    private void cargarEmpresasDesdeApi() {
        try {
            List<Empresa> empresas = EmpresaService.obtenerTodas();
            listaEmpresas.setAll(empresas);
        } catch (IOException e) {
            mostrarAlerta("Error al cargar empresas desde el servidor.");
        }
    }

    private void cargarDatos(Empresa empresa) {
        if (empresa != null) {
            nombreField.setText(empresa.getNombre());
            cifField.setText(empresa.getCif());
            telefonoField.setText(empresa.getTelefono());
        }
    }

    private boolean validarCampos() {
        String nombre = nombreField.getText().trim();
        String cif = cifField.getText().trim();
        String telefono = telefonoField.getText().trim();

        if (nombre.isEmpty() || cif.isEmpty() || telefono.isEmpty()) {
            mostrarAlerta("Todos los campos son obligatorios.");
            return false;
        }

        if (cif.length() < 8) {
            mostrarAlerta("El CIF debe tener al menos 8 caracteres.");
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

        Empresa nueva = new Empresa(nombreField.getText(), cifField.getText(), telefonoField.getText());

        try {
            Empresa guardada = EmpresaService.guardar(nueva);
            listaEmpresas.add(guardada);
            limpiarCampos();
        } catch (IOException e) {
            mostrarAlerta("Error al guardar la empresa en el servidor.");
        }
    }

    @FXML
    private void handleEditar() {
        Empresa seleccionada = tablaEmpresas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            if (!validarCampos()) return;

            seleccionada.setNombre(nombreField.getText());
            seleccionada.setCif(cifField.getText());
            seleccionada.setTelefono(telefonoField.getText());

            try {
                EmpresaService.actualizar(seleccionada);
                tablaEmpresas.refresh();
                limpiarCampos();
            } catch (IOException e) {
                mostrarAlerta("Error al actualizar la empresa en el servidor.");
            }
        } else {
            mostrarAlerta("Selecciona una empresa para editar.");
        }
    }

    @FXML
    private void handleEliminar() {
        Empresa seleccionada = tablaEmpresas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            try {
                EmpresaService.eliminar(seleccionada.getId());
                listaEmpresas.remove(seleccionada);
                limpiarCampos();
            } catch (IOException e) {
                mostrarAlerta("Error al eliminar la empresa en el servidor.");
            }
        } else {
            mostrarAlerta("Selecciona una empresa para eliminar.");
        }
    }

    @FXML
    private void handleLimpiar() {
        limpiarCampos();
    }

    private void limpiarCampos() {
        nombreField.clear();
        cifField.clear();
        telefonoField.clear();
        tablaEmpresas.getSelectionModel().clearSelection();
    }

    @FXML
    private void handleVolver() {
        Stage stage = (Stage) nombreField.getScene().getWindow();
        stage.close();
    }
}
