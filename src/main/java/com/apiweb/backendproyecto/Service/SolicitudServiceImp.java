package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Exception.RecursoNoEncontradoExcep;
import com.apiweb.backendproyecto.Model.SolicitudModel;
import com.apiweb.backendproyecto.Repository.ISolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudServiceImp implements ISolicitudService {
    @Autowired ISolicitudRepository solicitudRepository;

    @Override
    public List<SolicitudModel> obtenerSolicitudes() {
        return solicitudRepository.findAll();
    }

    @Override
    public String crearSolicitud(SolicitudModel solicitud) {
        solicitudRepository.save(solicitud);
        return "La solicitud ha sido creada correctamente";
    }

    @Override
    public SolicitudModel obtenerSolicitudPorId(int id) {
        Optional<SolicitudModel> solicitudRecuperada = solicitudRepository.findById(id);
        return solicitudRecuperada.orElseThrow(() -> new RecursoNoEncontradoExcep("No se encontro una solicitud con el id" + id));
    }
}
