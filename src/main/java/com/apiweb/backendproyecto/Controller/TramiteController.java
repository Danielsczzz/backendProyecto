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
@RequestMapping("/apirest/tramites")
public class TramiteController {
    @Autowired ITramiteService tramiteService;
    @Autowired ITipoTramiteService tipoTramiteService;
    @Autowired IUnidadService unidadService;
    @Autowired IUsuarioService usuarioService;
    @Autowired IDocumentoService documentoService;

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

    @PostMapping("/{id}/adicionarDocumentos/")
    public ResponseEntity<String> adicionarDocumentos(@PathVariable Integer id, @RequestBody List<DocumentoModel> listaDocumentos) {
        try {
            TramiteModel tramite = tramiteService.obtenerTramitePorId(id);
            if(tramite== null){
                throw new RecursoNoEncontradoExcep("No se encontro el tramite con el id "+id);
            }
            if (listaDocumentos == null && listaDocumentos.isEmpty()) {
                throw new RecursoNoEncontradoExcep("No se brindo informacion de los idiomas");
            }
            StringBuilder respuestaDocumentos = new StringBuilder();
            for (DocumentoModel data : listaDocumentos) {
                DocumentoModel documento = new DocumentoModel();
                documento.setArchivoURL(data.getArchivoURL());
                documento.setEstado(data.getEstado());
                documento.setIdTramite(tramite);
                String respuestaDocumento = documentoService.crearDocumento(documento);
                respuestaDocumentos.append(String.format("%s\n", respuestaDocumento));
            }
            return new ResponseEntity<>(respuestaDocumentos.toString().trim(), HttpStatus.OK);
        }  catch (RecursoNoEncontradoExcep e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
