package com.apiweb.backendproyecto.Controller;

import com.apiweb.backendproyecto.Exception.RecursoNoEncontradoExcep;
import com.apiweb.backendproyecto.Model.TipoTramiteModel;
import com.apiweb.backendproyecto.Model.TramiteModel;
import com.apiweb.backendproyecto.Model.UnidadModel;
import com.apiweb.backendproyecto.Model.UsuarioModel;
import com.apiweb.backendproyecto.Service.ITipoTramiteService;
import com.apiweb.backendproyecto.Service.ITramiteService;
import com.apiweb.backendproyecto.Service.IUnidadService;
import com.apiweb.backendproyecto.Service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apirest/tramites")
public class TramiteController {
    @Autowired ITramiteService tramiteService;
    @Autowired ITipoTramiteService tipoTramiteService;
    @Autowired IUnidadService unidadService;
    @Autowired IUsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<List<TramiteModel>> obtenerTramites(){
        return new ResponseEntity<>(tramiteService.obtenerTramites(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> crearTramite(@RequestBody TramiteModel tramite) {
        try {
            Integer idTipo = tramite.getIdTipo().getIdTipo();
            Integer idUnidad = tramite.getIdUnidad().getIdUnidad();
            Integer idUsuario = tramite.getIdUsuario().getIdUsuario();

            TipoTramiteModel tipo = tipoTramiteService.obtenerTipoTramitePorId(idTipo);
            UnidadModel unidad = unidadService.obtenerUnidadPorId(idUnidad);
            UsuarioModel usuario = usuarioService.obtenerUsuarioPorId(idUsuario);
            if(tipo == null || unidad == null || usuario == null) {
                throw new RecursoNoEncontradoExcep("No se pudo crear el tramite, no se encontro un recurso necesario para ser creado.");
            }
            return new ResponseEntity<>(tramiteService.crearTramite(tramite), HttpStatus.OK);
        } catch (RecursoNoEncontradoExcep e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
