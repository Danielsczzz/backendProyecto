package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.ReciboModel;
import com.apiweb.backendproyecto.Model.SolicitudModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReciboRepository extends JpaRepository<ReciboModel, Integer> {
    List<ReciboModel> findAllByIdSolicitud(SolicitudModel solicitud);
}
