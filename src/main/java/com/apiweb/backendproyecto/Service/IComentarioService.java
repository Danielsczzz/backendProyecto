package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.ComentarioModel;
import com.apiweb.backendproyecto.Model.SolicitudModel;

import java.util.List;

public interface IComentarioService {
    String crearComentario(ComentarioModel comentario);
    List<ComentarioModel> obtenerComentariosDeSolicitud(SolicitudModel solicitud);
}
