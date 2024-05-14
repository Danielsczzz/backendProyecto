package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.TramiteModel;
import com.apiweb.backendproyecto.Repository.ITramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return String.format("El tramite de tipo %s ha sido creado con exito.", tramite.getIdTipo().getTipo());
    }


}
