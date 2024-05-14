package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.UnidadModel;
import com.apiweb.backendproyecto.Repository.IUnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadServiceImp implements IUnidadService {
    @Autowired IUnidadRepository unidadRepository;

    @Override
    public List<UnidadModel> obtenerUnidades() {
        return unidadRepository.findAll();
    }

    @Override
    public String crearUnidad(UnidadModel unidad) {
        unidadRepository.save(unidad);
        return String.format("La unidad %s ha sido creado con exito", unidad.getNombre());
    }
}
