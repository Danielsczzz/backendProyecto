package com.apiweb.backendproyecto.Controller;

import com.apiweb.backendproyecto.Exception.RecursoNoEncontradoExcep;
import com.apiweb.backendproyecto.Model.DocumentoModel;
import com.apiweb.backendproyecto.Model.TramiteModel;
import com.apiweb.backendproyecto.Service.IDocumentoService;
import com.apiweb.backendproyecto.Service.ITramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apirest/documentos")
public class DocumentoController {
    @Autowired IDocumentoService documentoService;
    @Autowired ITramiteService tramiteService;

    @GetMapping("/")
    public ResponseEntity<List<DocumentoModel>> obtenerDocumentos() {
        return new ResponseEntity<>(documentoService.obtenerDocumentos(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> crearDocumento(@RequestBody DocumentoModel documento) {
        try {
            Integer idTramite = documento.getIdTramite().getIdTramite();
            TramiteModel tramite = tramiteService.obtenerTramitePorId(idTramite);
            if(tramite == null) {
                throw new RecursoNoEncontradoExcep(String.format("No existe un tramite con el id %s", documento.getIdTramite().getIdTramite()));
            }
            return new ResponseEntity<>(documentoService.crearDocumento(documento), HttpStatus.OK);
        } catch(RecursoNoEncontradoExcep e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
