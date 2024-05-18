package com.apiweb.backendproyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "recibo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReciboModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecibo;

    @Column(nullable = false)
    private Date fechaGeneracion;

    @Column(nullable = false)
    private String documentoURL;

    @ManyToOne
    @JoinColumn(name="idSolicitud")
    private SolicitudModel idSolicitud;
}
