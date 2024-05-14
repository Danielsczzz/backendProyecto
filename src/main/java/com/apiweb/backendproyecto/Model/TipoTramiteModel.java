package com.apiweb.backendproyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="telefono_unidad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoTramiteModel {
    @Id
    private Integer idTipo;

    @Column(nullable = false, unique = true)
    private String tipo;
}
