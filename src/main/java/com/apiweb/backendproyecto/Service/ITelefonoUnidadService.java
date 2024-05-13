package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.TelefonoUnidadModel;

import java.util.List;

public interface ITelefonoUnidadService {
    String crearTelefonoUnidad(TelefonoUnidadModel telefonoUnidad);
    List<TelefonoUnidadModel> obtenerTelefonosUnidad();
}
