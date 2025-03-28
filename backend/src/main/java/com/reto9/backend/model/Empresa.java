package com.reto9.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private String ubicacion;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    @JsonIgnore // 👈 Añade esto
    private List<Vacante> vacantes;

}