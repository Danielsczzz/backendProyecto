package com.apiweb.backendproyecto.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadDTO {
    private Integer idUnidad;
    private String nombre;
    private List<Map<String, String>> telefonos;
}
