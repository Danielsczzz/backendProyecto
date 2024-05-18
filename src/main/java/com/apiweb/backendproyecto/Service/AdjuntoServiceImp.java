package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.AdjuntoModel;
import com.apiweb.backendproyecto.Repository.IAdjuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdjuntoServiceImp implements IAdjuntoService{
    @Autowired IAdjuntoRepository adjuntoRepository;

    @Override
    public List<AdjuntoModel> obtenerAdjuntos() {
        return adjuntoRepository.findAll();
    }

    @Override
    public String crearAdjunto(AdjuntoModel adjunto) {
        adjuntoRepository.save(adjunto);
        return String.format("El adjunto %s ha sido creado correctamente", adjunto.getDocumentoURl());
    }
}
