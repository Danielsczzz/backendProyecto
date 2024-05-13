package com.apiweb.backendproyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="unidad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUnidad;

    @Column(nullable = false)
    private String nombre;

}
