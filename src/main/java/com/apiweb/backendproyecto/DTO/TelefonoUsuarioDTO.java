package com.apiweb.backendproyecto.DTO;

import com.apiweb.backendproyecto.Model.ENUM.Profesion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefonoUsuarioDTO {
    private String telefono;
    private Integer idUsuario;
}
