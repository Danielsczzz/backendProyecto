package com.apiweb.backendproyecto.Controller;

import com.apiweb.backendproyecto.Exception.RecursoNoEncontradoExcep;
import com.apiweb.backendproyecto.Model.*;
import com.apiweb.backendproyecto.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired IComentarioService comentarioService;


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

    @PostMapping("/{id}/adjuntos")
    public ResponseEntity<String> crearAdjuntosSolicitud(@PathVariable int id, @RequestBody List<AdjuntoModel> adjuntos) {
        try {
            SolicitudModel solicitud = solicitudService.obtenerSolicitudPorId(id);

            if(adjuntos == null || adjuntos.isEmpty() || solicitud == null) {
                throw new RecursoNoEncontradoExcep("No se pudo crear la solicitud, no se encontro un recurso necesario para ser creado.");
            }
            StringBuilder respuestaAdjuntos = new StringBuilder();
            for (AdjuntoModel data : adjuntos) {
                AdjuntoModel adjunto = new AdjuntoModel();
                adjunto.setDocumentoURL(data.getDocumentoURL());
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

    @GetMapping("/{id}/adjuntos")
    public ResponseEntity<List<AdjuntoModel>> obtenerAdjuntosDeSolicitud(@PathVariable Integer id) {
        try {
            SolicitudModel solicitud = solicitudService.obtenerSolicitudPorId(id);
            if( solicitud == null) {
                throw new RecursoNoEncontradoExcep("No se encontro una solicitud con este id" + id);
            }
            return new ResponseEntity<>(adjuntoService.obtenerAdjuntosDeSolicitud(solicitud), HttpStatus.OK);
        } catch (RecursoNoEncontradoExcep e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/{id}/comentarios")
    public ResponseEntity<String> crearComentario (@PathVariable int id, @RequestBody ComentarioModel comentario) {
        try {
            SolicitudModel solicitud = solicitudService.obtenerSolicitudPorId(id);
            if (solicitud == null) {
                throw new RecursoNoEncontradoExcep("No se encontro una solicitud con el id" + id);
            }
            comentario.setIdSolicitud(solicitud);
            return new ResponseEntity<>(comentarioService.crearComentario(comentario), HttpStatus.OK);
        } catch (RecursoNoEncontradoExcep e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());}
    }

    @GetMapping("/{id}/comentarios")
    public ResponseEntity<List<ComentarioModel>> obtenerComentariosDeSolicitud(@PathVariable Integer id) {
        try {
            SolicitudModel solicitud = solicitudService.obtenerSolicitudPorId(id);
            if(solicitud == null) {
                throw new RecursoNoEncontradoExcep("No se encontro una solicitud con este id" + id);
            }
            return new ResponseEntity<>(comentarioService.obtenerComentariosDeSolicitud(solicitud), HttpStatus.OK);
        } catch (RecursoNoEncontradoExcep e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/{id}/recibo")
    public ResponseEntity<String> crearRecibo(@PathVariable int id, @RequestBody ReciboModel recibo) {
        try {
            SolicitudModel solicitud = solicitudService.obtenerSolicitudPorId(id);
            if(solicitud == null) {
                throw new RecursoNoEncontradoExcep(String.format("No existe una solicitud con el id %s", recibo.getIdSolicitud()));
            }
            recibo.setIdSolicitud(solicitud);
            return new ResponseEntity<>(reciboService.crearRecibo(recibo), HttpStatus.OK);
        } catch(RecursoNoEncontradoExcep e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}/recibos")
    public ResponseEntity<?> obtenerRecibosDeSolicitud(@PathVariable int id){
        try {
            SolicitudModel solicitud = solicitudService.obtenerSolicitudPorId(id);
            if (solicitud == null) {
                throw new RecursoNoEncontradoExcep("No existe una solicitud con el id " + id);
            }
            return new ResponseEntity<>(reciboService.obtenerReciboDeSolicitud(solicitud), HttpStatus.OK);
        } catch(RecursoNoEncontradoExcep e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
