package com.apiweb.backendproyecto.Service;

import java.util.List;

public interface IConsultasService {
    List<Object[]> infoUsuario(int idUsuario);
    Object cantidadSolicitudesDeUsuario(int idUsuario);
    Object cantidadDineroFacturadoDeUsuario(int idUsuario);
}
