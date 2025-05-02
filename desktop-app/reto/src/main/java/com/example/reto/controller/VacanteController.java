package com.example.reto.controller;

import com.example.reto.model.Vacante;
import com.example.reto.service.VacanteService;
import com.example.reto.service.VacanteServiceImpl;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class VacanteController {

    private VacanteService vacanteService = new VacanteServiceImpl();
    private ObservableList<Vacante> vacantesList = FXCollections.observableArrayList();
    private ObservableList<Vacante> vacantesFiltradas = FXCollections.observableArrayList();
    private int paginaActual = 0;
    private static final int VACANTES_POR_PAGINA = 5;

    @FXML private TableView<Vacante> vacanteTable;
    @FXML private TableColumn<Vacante, String> tituloColumn, descripcionColumn, ubicacionColumn, estadoColumn, fechaColumn;
    @FXML private TextField tituloField, ubicacionField;
    @FXML private TextArea descripcionField;
    @FXML private ComboBox<String> estadoCombo, estadoFiltroCombo;
    @FXML private DatePicker fechaPicker;
    @FXML private VBox formularioVacante;
    @FXML private Label estadoLabel;
    @FXML private TextField ubicacionFiltroField;
    @FXML private Label paginaLabel;
    @FXML private TextField busquedaField;

    public void initialize() {
        tituloColumn.setCellValueFactory(cellData -> cellData.getValue().tituloProperty());
        descripcionColumn.setCellValueFactory(cellData -> cellData.getValue().descripcionProperty());
        ubicacionColumn.setCellValueFactory(cellData -> cellData.getValue().ubicacionProperty());
        estadoColumn.setCellValueFactory(cellData -> cellData.getValue().estadoProperty());
        fechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaProperty().asString());

        estadoFiltroCombo.setItems(FXCollections.observableArrayList("Todos", "CREADA", "ASIGNADA", "CANCELADA"));
        estadoFiltroCombo.getSelectionModel().select(0);

        estadoFiltroCombo.setOnAction(event -> filtrarVacantes());
        ubicacionFiltroField.setOnKeyReleased(event -> filtrarVacantes());

        vacanteTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Vacante vacanteSeleccionada = vacanteTable.getSelectionModel().getSelectedItem();
                if (vacanteSeleccionada != null) {
                    mostrarDetallesVacante(vacanteSeleccionada);
                }
            }
        });

        cargarVacantesPorPagina();
    }


    @FXML
    public void filtrarVacantes() {
        String busquedaTexto = busquedaField.getText().toLowerCase();
        String estadoFiltro = estadoFiltroCombo.getValue();
        String ubicacionFiltro = ubicacionFiltroField.getText().toLowerCase();

        vacantesFiltradas.clear();

        for (Vacante vacante : vacantesList) {
            boolean coincideBusqueda = vacante.getTitulo().toLowerCase().contains(busquedaTexto) ||
                    vacante.getDescripcion().toLowerCase().contains(busquedaTexto) ||
                    vacante.getUbicacion().toLowerCase().contains(busquedaTexto);
            boolean coincideEstado = estadoFiltro.equals("Todos") || vacante.getEstado().equals(estadoFiltro);
            boolean coincideUbicacion = vacante.getUbicacion().toLowerCase().contains(ubicacionFiltro);

            if (coincideBusqueda && coincideEstado && coincideUbicacion) {
                vacantesFiltradas.add(vacante);
            }
        }

        cargarVacantesPorPagina();
    }

    private void cargarVacantesPorPagina() {
        int inicio = paginaActual * VACANTES_POR_PAGINA;
        int fin = Math.min(inicio + VACANTES_POR_PAGINA, vacantesFiltradas.size());

        ObservableList<Vacante> vacantesPagina = FXCollections.observableArrayList(vacantesFiltradas.subList(inicio, fin));
        vacanteTable.setItems(vacantesPagina);
        paginaLabel.setText("Página " + (paginaActual + 1));
    }

    @FXML
    public void paginaSiguiente() {
        if ((paginaActual + 1) * VACANTES_POR_PAGINA < vacantesFiltradas.size()) {
            paginaActual++;
            cargarVacantesPorPagina();
        }
    }

    @FXML
    public void paginaAnterior() {
        if (paginaActual > 0) {
            paginaActual--;
            cargarVacantesPorPagina();
        }
    }

    private void mostrarDetallesVacante(Vacante vacante) {
        Stage detallesStage = new Stage();
        detallesStage.setTitle("Detalles de la Vacante");

        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setPadding(new javafx.geometry.Insets(20));

        Label tituloLabel = new Label("Título: " + vacante.getTitulo());
        tituloLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label descripcionLabel = new Label("Descripción:");
        descripcionLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        TextArea descripcionTextArea = new TextArea(vacante.getDescripcion());
        descripcionTextArea.setWrapText(true);
        descripcionTextArea.setEditable(false);
        descripcionTextArea.setPrefHeight(100);

        Label ubicacionLabel = new Label("Ubicación: " + vacante.getUbicacion());
        Label estadoLabel = new Label("Estado: " + vacante.getEstado());
        Label fechaLabel = new Label("Fecha de publicación: " + vacante.getFecha().toString());

        vbox.getChildren().addAll(tituloLabel, descripcionLabel, descripcionTextArea, ubicacionLabel, estadoLabel, fechaLabel);

        Scene scene = new Scene(vbox, 400, 300);
        detallesStage.setScene(scene);
        detallesStage.show();
    }

    @FXML
    public void crearVacante() {
        formularioVacante.setVisible(true);
        tituloField.clear();
        descripcionField.clear();
        ubicacionField.clear();
        estadoCombo.setValue("CREADA");
        estadoLabel.setVisible(false);
        estadoCombo.setVisible(false);
        fechaPicker.setValue(null);
    }

    @FXML
    public void editarVacante() {
        Vacante vacanteSeleccionada = vacanteTable.getSelectionModel().getSelectedItem();
        estadoLabel.setVisible(true);
        estadoCombo.setVisible(true);
        if (vacanteSeleccionada != null) {
            formularioVacante.setVisible(true);
            tituloField.setText(vacanteSeleccionada.getTitulo());
            descripcionField.setText(vacanteSeleccionada.getDescripcion());
            ubicacionField.setText(vacanteSeleccionada.getUbicacion());
            estadoCombo.setValue(vacanteSeleccionada.getEstado());
            if (vacanteSeleccionada.getFecha() instanceof java.util.Date) {
                java.util.Date fecha = vacanteSeleccionada.getFecha();
                fechaPicker.setValue(fecha.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
            } else {
                fechaPicker.setValue(null);
            }
            estadoLabel.setVisible(true);
            estadoCombo.setVisible(true);
        } else {
            mostrarMensaje("Por favor, selecciona una vacante para editar", Alert.AlertType.WARNING);
        }
    }

    @FXML
    public void eliminarVacante() {
        Vacante vacanteSeleccionada = vacanteTable.getSelectionModel().getSelectedItem();
        if (vacanteSeleccionada != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminar Vacante");
            alert.setHeaderText("Estás a punto de eliminar una vacante.");
            alert.setContentText("¿Estás seguro de que deseas eliminar esta vacante?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                vacantesList.remove(vacanteSeleccionada);
                vacantesFiltradas.remove(vacanteSeleccionada);
                vacanteTable.setItems(vacantesFiltradas);
                vacanteTable.getSelectionModel().clearSelection();
                mostrarMensaje("Vacante eliminada exitosamente", Alert.AlertType.INFORMATION);
            }
        } else {
            mostrarMensaje("Por favor, selecciona una vacante para eliminar", Alert.AlertType.WARNING);
        }
    }

    private void mostrarMensaje(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    public void guardarVacante() {
        if (validarFormulario()) {
            Vacante vacanteSeleccionada = vacanteTable.getSelectionModel().getSelectedItem();

            if (vacanteSeleccionada != null) {
                vacanteSeleccionada.setTitulo(tituloField.getText());
                vacanteSeleccionada.setDescripcion(descripcionField.getText());
                vacanteSeleccionada.setUbicacion(ubicacionField.getText());
                vacanteSeleccionada.setEstado(estadoCombo.getValue());
                vacanteSeleccionada.setFecha(java.sql.Date.valueOf(fechaPicker.getValue()));
                vacanteTable.refresh();
                mostrarMensaje("Vacante actualizada exitosamente", Alert.AlertType.INFORMATION);
            } else {
                Vacante nuevaVacante = new Vacante(tituloField.getText(), descripcionField.getText(),
                        ubicacionField.getText(), estadoCombo.getValue(), java.sql.Date.valueOf(fechaPicker.getValue()));

                vacantesList.add(nuevaVacante);
                filtrarVacantes();
                mostrarMensaje("Vacante creada exitosamente", Alert.AlertType.INFORMATION);
            }
            formularioVacante.setVisible(false);
        }
    }

    @FXML
    public void cancelarVacante() {
        formularioVacante.setVisible(false);
    }

    private boolean validarFormulario() {
        if (tituloField.getText().isEmpty() || descripcionField.getText().isEmpty() ||
                ubicacionField.getText().isEmpty() || estadoCombo.getValue() == null || fechaPicker.getValue() == null) {
            mostrarMensaje("Todos los campos son obligatorios", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    @FXML
    private void handleSalir() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/reto/LoginView.fxml"));
            Parent root = loader.load();
            Stage loginStage = new Stage();
            loginStage.setTitle("Iniciar sesión");
            loginStage.setScene(new Scene(root, 600, 400));
            loginStage.show();

            Stage stageActual = (Stage) vacanteTable.getScene().getWindow();
            stageActual.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





