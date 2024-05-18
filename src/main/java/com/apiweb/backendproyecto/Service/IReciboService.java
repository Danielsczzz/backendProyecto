package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.ReciboModel;

import java.util.List;

public interface IReciboService {
    List<ReciboModel> obtenerRecibos();
    String crearRecibo(ReciboModel recibo);
}
