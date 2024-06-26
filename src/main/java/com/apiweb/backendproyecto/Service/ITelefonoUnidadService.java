package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.TelefonoUnidadModel;
import com.apiweb.backendproyecto.Model.UnidadModel;

import java.util.List;

public interface ITelefonoUnidadService {
    String crearTelefonoUnidad(TelefonoUnidadModel telefonoUnidad);
    List<TelefonoUnidadModel> obtenerTelefonosDeUnidad(UnidadModel unidad);
}
