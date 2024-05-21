package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Exception.RecursoNoEncontradoExcep;
import com.apiweb.backendproyecto.Model.TramiteModel;
import com.apiweb.backendproyecto.Repository.ITramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TramiteServiceImp implements ITramiteService {
    @Autowired ITramiteRepository tramiteRepository;

    @Override
    public List<TramiteModel> obtenerTramites() {
        return tramiteRepository.findAll();
    }

    @Override
    public String crearTramite(TramiteModel tramite) {
        tramiteRepository.save(tramite);
        return "El tramite ha sido creado con exito.";
    }

    @Override
    public TramiteModel obtenerTramitePorId(int id) {
        Optional<TramiteModel> tramiteRecuperado = tramiteRepository.findById(id);
        return tramiteRecuperado.orElseThrow(() -> new RecursoNoEncontradoExcep(String.format("No existe un tramite con el id %d", id)));
    }
}
