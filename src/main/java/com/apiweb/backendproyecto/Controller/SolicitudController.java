package com.apiweb.backendproyecto.Controller;

import com.apiweb.backendproyecto.Exception.RecursoNoEncontradoExcep;
import com.apiweb.backendproyecto.Model.*;
import com.apiweb.backendproyecto.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apirest/solicitudes")
public class SolicitudController {

    @Autowired ISolicitudService solicitudService;
    @Autowired ITramiteService tramiteService;
    @Autowired IUsuarioService usuarioService;
    @Autowired IAdjuntoService adjuntoService;
    @Autowired IReciboService reciboService;


    @GetMapping("/")
    public ResponseEntity<List<SolicitudModel>> obtenerSolicitudes() {
        return new ResponseEntity<>(solicitudService.obtenerSolicitudes(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> crearSolicitud(@RequestBody SolicitudModel solicitud) {
        try {
            Integer idTramite = solicitud.getIdTramite().getIdTramite();
            Integer idUsuario = solicitud.getIdUsuario().getIdUsuario();

            TramiteModel tramite = tramiteService.obtenerTramitePorId(idTramite);
            UsuarioModel usuario = usuarioService.obtenerUsuarioPorId(idUsuario);

            if(tramite == null || usuario == null) {
                throw new RecursoNoEncontradoExcep("No se pudo crear la solicitud, no se encontro un recurso necesario para ser creado.");
            }
            return new ResponseEntity<>(solicitudService.crearSolicitud(solicitud), HttpStatus.OK);
        } catch (RecursoNoEncontradoExcep e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/{id}/crearAdjuntos")
    public ResponseEntity<String> crearAdjuntosSolicitud(@Param("id") Integer id, @RequestBody List<AdjuntoModel> adjuntos) {
        try {
            SolicitudModel solicitud = solicitudService.obtenerSolicitudPorId(id);

            if(adjuntos == null || adjuntos.isEmpty() || solicitud == null) {
                throw new RecursoNoEncontradoExcep("No se pudo crear la solicitud, no se encontro un recurso necesario para ser creado.");
            }
            StringBuilder respuestaAdjuntos = new StringBuilder();
            for (AdjuntoModel data : adjuntos) {
                AdjuntoModel adjunto = new AdjuntoModel();
                adjunto.setDocumentoURl(data.getDocumentoURl());
                adjunto.setTipo(data.getTipo());
                adjunto.setIdSolicitud(solicitud);
                String respuestaAdjunto = adjuntoService.crearAdjunto(adjunto);
                respuestaAdjuntos.append(String.format("%s\n", respuestaAdjunto));
            }
            return new ResponseEntity<>(respuestaAdjuntos.toString(), HttpStatus.OK);
        } catch (RecursoNoEncontradoExcep e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
