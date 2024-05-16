package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.TipoTramiteModel;

import java.util.List;

public interface ITipoTramiteService {
    String crearTipoTramite(TipoTramiteModel tipo);
    List<TipoTramiteModel> obtenerTipoTramites();
    TipoTramiteModel obtenerTipoTramitePorId(Integer id);
    List<String> obtenerTipoTramiteMasRecurrente();
}
