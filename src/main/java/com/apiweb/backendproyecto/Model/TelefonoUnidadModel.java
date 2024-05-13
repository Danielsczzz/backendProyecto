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
public class TelefonoUnidadModel {
    @Id
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "idUnidad")
    private UnidadModel idUnidad;

}
