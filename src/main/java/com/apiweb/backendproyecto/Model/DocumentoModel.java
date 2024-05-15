package com.apiweb.backendproyecto.Model;

import com.apiweb.backendproyecto.Model.ENUM.EstadoDocumento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocumento;

    @Column(nullable = false)
    private String archivoURL;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoDocumento estado;

    @ManyToOne
    @JoinColumn(name="idTramite")
    private TramiteModel idTramite;
}
