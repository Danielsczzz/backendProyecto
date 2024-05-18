package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.ReciboModel;
import com.apiweb.backendproyecto.Repository.IReciboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReciboServiceImp implements IReciboService {
    @Autowired IReciboRepository reciboRepository;

    @Override
    public List<ReciboModel> obtenerRecibos() {
        return reciboRepository.findAll();
    }

    @Override
    public String crearRecibo(ReciboModel recibo) {
        reciboRepository.save(recibo);
        return "El recibo ha sido creado correctamente";
    }
}
