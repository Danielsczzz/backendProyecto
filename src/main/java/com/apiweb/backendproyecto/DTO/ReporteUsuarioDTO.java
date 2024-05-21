package com.apiweb.backendproyecto.DTO;

import com.apiweb.backendproyecto.Model.ENUM.EstadoSolicitud;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteUsuarioDTO {
    private Integer idUsuario;
    private String nombre;
    private String correo;
    // private EstadoSolicitud estado;
    // private Date fechaGeneracion;
    // private Integer cantSolicitudes;
    // private Double sumaPagos;
}
