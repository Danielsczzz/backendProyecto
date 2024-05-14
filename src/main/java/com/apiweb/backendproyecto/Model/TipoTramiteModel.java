package com.apiweb.backendproyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tipo_tramite")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoTramiteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipo;

    @Column(nullable = false, unique = true)
    private String tipo;
}
