package com.apiweb.backendproyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tramite")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TramiteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTramite;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String normativa;

    @Column(nullable = false)
    private Boolean esPago;

    @Column
    private Float costo;

    @ManyToOne
    @JoinColumn(name = "idTipo")
    private TipoTramiteModel idTipo;

    @ManyToOne
    @JoinColumn(name = "idUnidad")
    private UnidadModel idUnidad;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel idUsuario;
}
