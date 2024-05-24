package com.apiweb.backendproyecto.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteUsuarioDTO {
    private String nombre;
    private String correo;
    private String profesion;
    private String cantidadSolicitudes;
    private String dineroFacturado;
}
