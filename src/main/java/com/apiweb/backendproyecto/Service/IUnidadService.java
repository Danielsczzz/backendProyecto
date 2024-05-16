package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.UnidadModel;

import java.util.List;

public interface IUnidadService {
    List<UnidadModel> obtenerUnidades();
    String crearUnidad(UnidadModel unidad);
    UnidadModel obtenerUnidadPorId(Integer id);
    List<String> obtenerUnidadMasLucrativa();
}
