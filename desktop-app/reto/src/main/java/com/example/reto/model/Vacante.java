package com.example.reto.model;

import javafx.beans.property.*;

import java.util.Date;

public class Vacante {

    private Long id;
    private StringProperty titulo;
    private StringProperty descripcion;
    private StringProperty ubicacion;
    private StringProperty estado;
    private ObjectProperty<Date> fecha; // Usamos ObjectProperty para la fecha

    // Constructor con todos los parámetros
    public Vacante(String titulo, String descripcion, String ubicacion, String estado, Date fecha) {
        this.titulo = new SimpleStringProperty(titulo);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.ubicacion = new SimpleStringProperty(ubicacion);
        this.estado = new SimpleStringProperty(estado);
        this.fecha = new SimpleObjectProperty<>(fecha); // Inicializamos la fecha con ObjectProperty
    }

    // Constructor sin ID (para crear una vacante nueva)
    public Vacante(String titulo, String descripcion, String ubicacion, String estado, Date fecha, Long id) {
        this(titulo, descripcion, ubicacion, estado, fecha);
        this.id = id;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo.get();
    }

    public void setTitulo(String titulo) {
        this.titulo.set(titulo);
    }

    public StringProperty tituloProperty() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }

    public String getUbicacion() {
        return ubicacion.get();
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion.set(ubicacion);
    }

    public StringProperty ubicacionProperty() {
        return ubicacion;
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String estado) {
        this.estado.set(estado);
    }

    public StringProperty estadoProperty() {
        return estado;
    }

    public Date getFecha() {
        return fecha.get();
    }

    public void setFecha(Date fecha) {
        this.fecha.set(fecha);
    }

    public ObjectProperty<Date> fechaProperty() {
        return fecha;
    }

    // Métodos útiles, como el de mostrar una representación en String de la vacante
    @Override
    public String toString() {
        return "Vacante{" +
                "id=" + id +
                ", titulo='" + titulo.get() + '\'' +
                ", descripcion='" + descripcion.get() + '\'' +
                ", ubicacion='" + ubicacion.get() + '\'' +
                ", estado='" + estado.get() + '\'' +
                ", fecha=" + fecha.get() +
                '}';
    }
}
