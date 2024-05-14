package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Exception.RecursoNoEncontradoExcep;
import com.apiweb.backendproyecto.Model.TipoTramiteModel;
import com.apiweb.backendproyecto.Model.UnidadModel;
import com.apiweb.backendproyecto.Repository.ITipoTramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoTramiteServiceImp implements ITipoTramiteService {
    @Autowired ITipoTramiteRepository tipoTramiteRepository;

    @Override
    public List<TipoTramiteModel> obtenerTipoTramites() {
        return tipoTramiteRepository.findAll();
    }

    @Override
    public String crearTipoTramite(TipoTramiteModel tipo) {
        tipoTramiteRepository.save(tipo);
        return String.format("El tipo de tramite %s ha sido creado con exito", tipo.getTipo());
    }

    @Override
    public TipoTramiteModel obtenerTipoTramitePorId(Integer id) {
        Optional<TipoTramiteModel> tipoTramiteRecuperado = tipoTramiteRepository.findById(id);
        return tipoTramiteRecuperado.orElseThrow(() -> new RecursoNoEncontradoExcep(String.format("No existe un tipo de tramite con el id %d", id)));
    }
}
