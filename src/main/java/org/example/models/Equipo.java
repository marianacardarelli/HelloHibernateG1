package org.example.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Equipo") //las entidades viven en la tabla equipo
public class Equipo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //mi id lo genera la base de datos
    private Long id;
    private String nombre;
    private String categoria;
    private Boolean disponible;
}
