package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.UnidadModel;

import java.util.List;
import java.util.Map;

public interface IUnidadService {
    List<UnidadModel> obtenerUnidades();
    String crearUnidad(UnidadModel unidad);
    UnidadModel obtenerUnidadPorId(Integer id);
    List<Map<String, Double>> obtenerUnidadMasLucrativa();
}
