package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.ReciboModel;
import com.apiweb.backendproyecto.Model.SolicitudModel;

import java.util.List;

public interface IReciboService {
    String crearRecibo(ReciboModel recibo);
    List<ReciboModel> obtenerReciboDeSolicitud(SolicitudModel solicitud);
}
