package com.apiweb.backendproyecto.Controller;

import com.apiweb.backendproyecto.Model.TipoTramiteModel;
import com.apiweb.backendproyecto.Service.ITipoTramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apirest/tipoTramite")
public class TipoTramiteController {

    @Autowired ITipoTramiteService tipoTramiteService;

    @GetMapping("/")
    public ResponseEntity<List<TipoTramiteModel>> obtenerTipoTramites(){
        return new ResponseEntity<>(tipoTramiteService.obtenerTipoTramites(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> crearTipoTramite(@RequestBody TipoTramiteModel tipo) {
        return new ResponseEntity<>(tipoTramiteService.crearTipoTramite(tipo), HttpStatus.OK);
    }

    @GetMapping("/recurrente")
    public ResponseEntity<List<Map<String, Integer>>> obtenerTipoTramiteMasRecurrente(){
        return new ResponseEntity<>(tipoTramiteService.obtenerTipoTramiteMasRecurrente(), HttpStatus.OK);
    }
}
