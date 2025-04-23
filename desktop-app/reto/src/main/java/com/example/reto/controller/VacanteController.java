package com.example.reto.controller;

import com.example.reto.model.Vacante;
import com.example.reto.service.VacanteService;
import com.example.reto.service.VacanteServiceImpl;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;

public class VacanteController {

    private VacanteService vacanteService = new VacanteServiceImpl(); // Conexión con el servicio
    private ObservableList<Vacante> vacantesList = FXCollections.observableArrayList(); // Lista local de vacantes
    private ObservableList<Vacante> vacantesFiltradas = FXCollections.observableArrayList(); // Lista filtrada de vacantes
    private int paginaActual = 0;
    private static final int VACANTES_POR_PAGINA = 5;  // Número de vacantes por página

    @FXML
    private TableView<Vacante> vacanteTable;

    @FXML
    private TableColumn<Vacante, String> tituloColumn, descripcionColumn, ubicacionColumn, estadoColumn, fechaColumn;

    @FXML
    private TextField tituloField, ubicacionField;

    @FXML
    private TextArea descripcionField;

    @FXML
    private ComboBox<String> estadoCombo, estadoFiltroCombo;

    @FXML
    private DatePicker fechaPicker;

    @FXML
    private VBox formularioVacante;  // El formulario de crear/editar vacante

    @FXML
    private Label estadoLabel;

    @FXML
    private TextField ubicacionFiltroField;

    @FXML
    private Label paginaLabel;

    @FXML
    private TextField busquedaField;

    // Inicialización
    public void initialize() {
        // Configurar las columnas de la tabla
        tituloColumn.setCellValueFactory(cellData -> cellData.getValue().tituloProperty());
        descripcionColumn.setCellValueFactory(cellData -> cellData.getValue().descripcionProperty());
        ubicacionColumn.setCellValueFactory(cellData -> cellData.getValue().ubicacionProperty());
        estadoColumn.setCellValueFactory(cellData -> cellData.getValue().estadoProperty());
        fechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaProperty().asString());

        // Configuración de la ComboBox de estados para filtrar
        estadoFiltroCombo.setItems(FXCollections.observableArrayList("Todos", "CREADA", "ASIGNADA", "CANCELADA"));
        estadoFiltroCombo.getSelectionModel().select(0);  // Seleccionar "Todos" por defecto

        // Detectar cambio en los filtros
        estadoFiltroCombo.setOnAction(event -> filtrarVacantes());
        ubicacionFiltroField.setOnKeyReleased(event -> filtrarVacantes());

        // Detectar el doble clic en la tabla
        vacanteTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {  // Verificar si es doble clic
                Vacante vacanteSeleccionada = vacanteTable.getSelectionModel().getSelectedItem();
                if (vacanteSeleccionada != null) {
                    mostrarDetallesVacante(vacanteSeleccionada);  // Mostrar los detalles de la vacante
                }
            }
        });

        // Cargar las vacantes al iniciar
        cargarVacantes();
        cargarVacantesPorPagina();
    }

    // Método para cargar las vacantes de prueba (50 vacantes)
    private void cargarVacantes() {
        for (int i = 1; i <= 50; i++) {
            vacantesList.add(new Vacante("Vacante " + i, "Descripción de la vacante " + i, "Ubicación " + (i % 3 == 0 ? "Madrid" : "Barcelona"), i % 3 == 0 ? "CREADA" : i % 3 == 1 ? "ASIGNADA" : "CANCELADA", new java.util.Date()));
        }
        filtrarVacantes();  // Cargar las vacantes filtradas
    }

    // Filtrar las vacantes por estado y ubicación
    @FXML
    public void filtrarVacantes() {
        String busquedaTexto = busquedaField.getText().toLowerCase();
        String estadoFiltro = estadoFiltroCombo.getValue();
        String ubicacionFiltro = ubicacionFiltroField.getText().toLowerCase();

        vacantesFiltradas.clear();

        // Filtrar vacantes según el texto de búsqueda y los filtros aplicados
        for (Vacante vacante : vacantesList) {
            boolean coincideBusqueda = vacante.getTitulo().toLowerCase().contains(busquedaTexto) ||
                    vacante.getDescripcion().toLowerCase().contains(busquedaTexto) ||
                    vacante.getUbicacion().toLowerCase().contains(busquedaTexto);
            boolean coincideEstado = estadoFiltro.equals("Todos") || vacante.getEstado().equals(estadoFiltro);
            boolean coincideUbicacion = vacante.getUbicacion().toLowerCase().contains(ubicacionFiltro);

            // Añadir a la lista filtrada solo las vacantes que coinciden con todos los filtros
            if (coincideBusqueda && coincideEstado && coincideUbicacion) {
                vacantesFiltradas.add(vacante);
            }
        }

        cargarVacantesPorPagina();  // Actualizar la tabla con los resultados filtrados
    }

    // Cargar vacantes por página
    private void cargarVacantesPorPagina() {
        // Calcular el índice de inicio y fin para la página actual
        int inicio = paginaActual * VACANTES_POR_PAGINA;
        int fin = Math.min(inicio + VACANTES_POR_PAGINA, vacantesFiltradas.size());

        // Crear una lista con las vacantes que se mostrarán en la página actual
        ObservableList<Vacante> vacantesPagina = FXCollections.observableArrayList(vacantesFiltradas.subList(inicio, fin));

        // Actualizar la tabla con las vacantes de la página
        vacanteTable.setItems(vacantesPagina);

        // Actualizar el texto de la página
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

    // Mostrar los detalles de la vacante seleccionada en una nueva ventana emergente
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

    // Crear vacante
    @FXML
    public void crearVacante() {
        // Hacer visible el formulario para crear una nueva vacante
        formularioVacante.setVisible(true);

        // Limpiar los campos del formulario
        tituloField.clear();
        descripcionField.clear();
        ubicacionField.clear();
        estadoCombo.setValue("CREADA"); // Establecer el estado por defecto a "CREADA"
        estadoLabel.setVisible(false); // Ocultar la etiqueta de estado al crear una vacante
        estadoCombo.setVisible(false); // Ocultar el ComboBox de estado al crear una vacante
        fechaPicker.setValue(null); // Limpiar la fecha
    }

    // Editar vacante
    @FXML
    public void editarVacante() {
        Vacante vacanteSeleccionada = vacanteTable.getSelectionModel().getSelectedItem();
        if (vacanteSeleccionada != null) {
            // Mostrar el formulario con los datos de la vacante seleccionada
            formularioVacante.setVisible(true);
            tituloField.setText(vacanteSeleccionada.getTitulo());
            descripcionField.setText(vacanteSeleccionada.getDescripcion());
            ubicacionField.setText(vacanteSeleccionada.getUbicacion());
            estadoCombo.setValue(vacanteSeleccionada.getEstado());
            fechaPicker.setValue(java.time.LocalDate.ofInstant(vacanteSeleccionada.getFecha().toInstant(), java.time.ZoneId.systemDefault()));

            // Hacer visibles la etiqueta y el ComboBox de estado al editar
            estadoLabel.setVisible(true);  // Mostrar la etiqueta de estado
            estadoCombo.setVisible(true);  // Mostrar el ComboBox de estado
        } else {
            mostrarMensaje("Por favor, selecciona una vacante para editar", Alert.AlertType.WARNING);
        }
    }

    // Eliminar vacante
    @FXML
    public void eliminarVacante() {
        Vacante vacanteSeleccionada = vacanteTable.getSelectionModel().getSelectedItem();
        if (vacanteSeleccionada != null) {
            // Confirmar si está seguro de eliminar la vacante
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminar Vacante");
            alert.setHeaderText("Estás a punto de eliminar una vacante.");
            alert.setContentText("¿Estás seguro de que deseas eliminar esta vacante?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Eliminar de la lista de vacantes
                vacantesList.remove(vacanteSeleccionada); // Eliminar de la lista principal
                vacantesFiltradas.remove(vacanteSeleccionada); // Eliminar de la lista filtrada si existe

                // Actualizar la tabla
                vacanteTable.setItems(vacantesFiltradas); // Actualizar la tabla con la lista filtrada

                // Deseleccionar cualquier vacante seleccionada
                vacanteTable.getSelectionModel().clearSelection();

                mostrarMensaje("Vacante eliminada exitosamente", Alert.AlertType.INFORMATION);
            }
        } else {
            mostrarMensaje("Por favor, selecciona una vacante para eliminar", Alert.AlertType.WARNING);
        }
    }


    // Mostrar un mensaje de alerta
    private void mostrarMensaje(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Guardar vacante
    @FXML
    public void guardarVacante() {
        // Validación y creación o actualización de vacante
        if (validarFormulario()) {
            Vacante vacanteSeleccionada = vacanteTable.getSelectionModel().getSelectedItem();

            if (vacanteSeleccionada != null) {
                // Si es una vacante seleccionada (en modo edición)
                vacanteSeleccionada.setTitulo(tituloField.getText());
                vacanteSeleccionada.setDescripcion(descripcionField.getText());
                vacanteSeleccionada.setUbicacion(ubicacionField.getText());
                vacanteSeleccionada.setEstado(estadoCombo.getValue());
                vacanteSeleccionada.setFecha(java.sql.Date.valueOf(fechaPicker.getValue()));

                // Actualizar la tabla después de la modificación
                vacanteTable.refresh();  // Refrescar la tabla para mostrar los cambios
                mostrarMensaje("Vacante actualizada exitosamente", Alert.AlertType.INFORMATION);
            } else {
                // Si no hay vacante seleccionada, es una creación nueva
                Vacante nuevaVacante = new Vacante(tituloField.getText(), descripcionField.getText(),
                        ubicacionField.getText(), estadoCombo.getValue(), java.sql.Date.valueOf(fechaPicker.getValue()));

                // Agregar la nueva vacante a la lista
                vacantesList.add(nuevaVacante);
                vacanteTable.refresh();  // Refrescar la tabla con la nueva vacante
                mostrarMensaje("Vacante creada exitosamente", Alert.AlertType.INFORMATION);
            }

            // Ocultar el formulario después de guardar
            formularioVacante.setVisible(false);
        }
    }

    // Cancelar vacante
    @FXML
    public void cancelarVacante() {
        // Hacer invisible el formulario
        formularioVacante.setVisible(false);
    }

    // Validar el formulario
    private boolean validarFormulario() {
        if (tituloField.getText().isEmpty() || descripcionField.getText().isEmpty() ||
                ubicacionField.getText().isEmpty() || estadoCombo.getValue() == null || fechaPicker.getValue() == null) {
            mostrarMensaje("Todos los campos son obligatorios", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

}




