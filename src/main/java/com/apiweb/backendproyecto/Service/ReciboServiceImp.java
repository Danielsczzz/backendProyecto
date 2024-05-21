package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.ReciboModel;
import com.apiweb.backendproyecto.Model.SolicitudModel;
import com.apiweb.backendproyecto.Repository.IReciboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReciboServiceImp implements IReciboService {
    @Autowired IReciboRepository reciboRepository;

    @Override
    public String crearRecibo(ReciboModel recibo) {
        reciboRepository.save(recibo);
        return "El recibo ha sido creado correctamente";
    }

    @Override
    public List<ReciboModel> obtenerReciboDeSolicitud(SolicitudModel solicitud) {
        return reciboRepository.findAllByIdSolicitud(solicitud);
    }
}
