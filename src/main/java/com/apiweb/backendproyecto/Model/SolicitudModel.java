package com.apiweb.backendproyecto.Model;

import com.apiweb.backendproyecto.Model.ENUM.EstadoSolicitud;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "solicitud")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idsolicitud;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoSolicitud estado;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date fechaGeneracion;

    @ManyToOne
    @JoinColumn(name="idTramite")
    private TramiteModel idTramite;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private UsuarioModel idUsuario;
}
