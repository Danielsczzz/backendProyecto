package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.UnidadModel;

import java.util.List;

public interface IUnidadService {
    String crearUnidad(UnidadModel unidad);
    List<UnidadModel> obtenerUnidades();
}
