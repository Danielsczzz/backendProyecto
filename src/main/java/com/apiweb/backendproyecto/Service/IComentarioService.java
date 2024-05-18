package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.ComentarioModel;

import java.util.List;

public interface IComentarioService {
    List<ComentarioModel> obtenerComentarios();
    String crearComentario(ComentarioModel comentario);

}
