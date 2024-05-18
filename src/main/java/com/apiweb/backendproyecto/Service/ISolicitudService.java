package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.SolicitudModel;

import java.util.List;

public interface ISolicitudService {
    List<SolicitudModel> obtenerSolicitudes();
    String crearSolicitud(SolicitudModel solicitud);
    SolicitudModel obtenerSolicitudPorId(int id);
}
