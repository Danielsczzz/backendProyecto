package com.apiweb.backendproyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comentario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    @Column(nullable = false)
    private String texto;

    @Column(nullable = false)
    private String mediaURL;

    @ManyToOne
    @JoinColumn(name="idSolicitud")
    private SolicitudModel idSolicitud;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private UsuarioModel idUsuario;

    @ManyToOne
    @JoinColumn(name="idRespuesta")
    private ComentarioModel idRespuesta;
}
