package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.AdjuntoModel;
import com.apiweb.backendproyecto.Model.SolicitudModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAdjuntoRepository extends JpaRepository<AdjuntoModel, Integer> {
    List<AdjuntoModel> findByIdSolicitud(SolicitudModel solicitud);
}
