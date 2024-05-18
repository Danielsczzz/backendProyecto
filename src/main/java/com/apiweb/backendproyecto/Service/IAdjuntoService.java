package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.AdjuntoModel;

import java.util.List;

public interface IAdjuntoService {
    List<AdjuntoModel> obtenerAdjuntos();
    String crearAdjunto(AdjuntoModel adjunto);
}
