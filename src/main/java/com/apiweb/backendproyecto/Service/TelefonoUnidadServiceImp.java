package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.TelefonoUnidadModel;
import com.apiweb.backendproyecto.Model.UnidadModel;
import com.apiweb.backendproyecto.Repository.ITelefonoUnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefonoUnidadServiceImp implements ITelefonoUnidadService {
    @Autowired ITelefonoUnidadRepository telefonoUnidadRepository;

    @Override
    public String crearTelefonoUnidad(TelefonoUnidadModel telefonoUnidad) {
        telefonoUnidadRepository.save(telefonoUnidad);
        return String.format("El telefono %s ha sido agregado correctamente", telefonoUnidad.getTelefono());
    }

    @Override
    public List<TelefonoUnidadModel> obtenerTelefonosDeUnidad(UnidadModel unidad) {
        return telefonoUnidadRepository.findAllByIdUnidad(unidad);
    }
}
