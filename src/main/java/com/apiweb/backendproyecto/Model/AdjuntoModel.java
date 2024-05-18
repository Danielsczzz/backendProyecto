package com.apiweb.backendproyecto.Model;

import com.apiweb.backendproyecto.Model.ENUM.TipoAdjunto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adjunto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdjuntoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdjunto;

    @Column(nullable = false)
    private String documentoURl;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoAdjunto tipo;

    @ManyToOne
    @JoinColumn(name = "idSolicitud")
    private SolicitudModel idSolicitud;
}
