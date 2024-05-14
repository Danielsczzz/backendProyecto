package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.TipoTramiteModel;
import com.apiweb.backendproyecto.Repository.ITipoTramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
