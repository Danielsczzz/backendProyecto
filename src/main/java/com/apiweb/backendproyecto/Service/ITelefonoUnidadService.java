package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.TelefonoUnidadModel;

import java.util.List;

public interface ITelefonoUnidadService {
    List<TelefonoUnidadModel> obtenerTelefonosUnidad();
    String crearTelefonoUnidad(TelefonoUnidadModel telefonoUnidad);
}
