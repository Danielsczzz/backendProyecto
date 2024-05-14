package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.TramiteModel;

import java.util.List;

public interface ITramiteService {
    String crearTramite(TramiteModel tramite);
    List<TramiteModel> obtenerTramites();
}
