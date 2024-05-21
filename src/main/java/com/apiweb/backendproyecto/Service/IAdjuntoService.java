package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.AdjuntoModel;
import com.apiweb.backendproyecto.Model.SolicitudModel;

import java.util.List;


public interface IAdjuntoService {
    String crearAdjunto(AdjuntoModel adjunto);
    List<AdjuntoModel> obtenerAdjuntosDeSolicitud(SolicitudModel Solicitud);
}
