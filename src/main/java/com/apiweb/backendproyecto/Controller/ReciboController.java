package com.apiweb.backendproyecto.Controller;

import com.apiweb.backendproyecto.Exception.RecursoNoEncontradoExcep;
import com.apiweb.backendproyecto.Model.DocumentoModel;
import com.apiweb.backendproyecto.Model.ReciboModel;
import com.apiweb.backendproyecto.Model.TramiteModel;
import com.apiweb.backendproyecto.Service.IReciboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apirest/recibos")
public class ReciboController {

    @Autowired
    IReciboService reciboService;

    @GetMapping("/")
    public ResponseEntity<List<ReciboModel>> obtenerRecibos() {
        return new ResponseEntity<>(reciboService.obtenerRecibos(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> crearRecibo(@RequestBody ReciboModel recibo) {
        try {
            Integer idSolicitud = recibo.getIdSolicitud().getIdsolicitud();
            if(idSolicitud == null) {
                throw new RecursoNoEncontradoExcep(String.format("No existe una solicitud con el id %s", recibo.getIdSolicitud()));
            }
            return new ResponseEntity<>(reciboService.crearRecibo(recibo), HttpStatus.OK);
        } catch(RecursoNoEncontradoExcep e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
