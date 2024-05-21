package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.ComentarioModel;
import com.apiweb.backendproyecto.Model.SolicitudModel;
import com.apiweb.backendproyecto.Repository.IComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImp implements IComentarioService{
    @Autowired IComentarioRepository comentarioRepository;

    @Override
    public String crearComentario(ComentarioModel comentario) {
        comentarioRepository.save(comentario);
        return "Comentario creado correctamente";
    }

    @Override
    public List<ComentarioModel> obtenerComentariosDeSolicitud(SolicitudModel solicitud) {
        return comentarioRepository.findAllByIdSolicitud(solicitud);
    }
}
