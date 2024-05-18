package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.TipoTramiteModel;

import java.util.List;
import java.util.Map;

public interface ITipoTramiteService {
    String crearTipoTramite(TipoTramiteModel tipo);
    List<TipoTramiteModel> obtenerTipoTramites();
    TipoTramiteModel obtenerTipoTramitePorId(Integer id);
    List<Map<String, Integer>> obtenerTipoTramiteMasRecurrente();
}
