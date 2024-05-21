package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.ComentarioModel;
import com.apiweb.backendproyecto.Model.SolicitudModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IComentarioRepository extends JpaRepository<ComentarioModel, Integer> {
    List<ComentarioModel> findAllByIdSolicitud(SolicitudModel solicitud);
}
