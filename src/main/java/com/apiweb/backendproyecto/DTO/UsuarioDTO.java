package com.apiweb.backendproyecto.DTO;

import com.apiweb.backendproyecto.Model.ENUM.Profesion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Integer idUsuario;
    private String nombre;
    private String correo;
    private Profesion profesion;
    private List<Map<String,String>> telefonos;
}
