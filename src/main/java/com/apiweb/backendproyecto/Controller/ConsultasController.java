package com.apiweb.backendproyecto.Controller;

import com.apiweb.backendproyecto.DTO.ReporteUsuarioDTO;
import com.apiweb.backendproyecto.Exception.RecursoNoEncontradoExcep;
import com.apiweb.backendproyecto.Model.UsuarioModel;
import com.apiweb.backendproyecto.Repository.IUsuarioRepository;
import com.apiweb.backendproyecto.Service.IConsultasService;
import com.apiweb.backendproyecto.Service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/apirest/consultas")
@RestController
public class ConsultasController {

    @Autowired IConsultasService consultasService;
    @Autowired IUsuarioService usuarioService;


    /**
     * Devuelve el reporte de un usuario
     *
     *@return Retorna una lista de objetos: idUsuario, nombre, correo, profesion, cantidadSolicitudes y cantidadFacturado.
     */
    @GetMapping("/reporte/usuarios/{id}")
    public ResponseEntity<?> obtenerReporteUsuario(@PathVariable int id) {
        try {
            UsuarioModel usuario = usuarioService.obtenerUsuarioPorId(id);

            if(usuario == null) {
                throw new RecursoNoEncontradoExcep("no se encontro un usuario con el id " + id);
            }
            return new ResponseEntity<>(consultasService.reporteUsuario(usuario.getIdUsuario()), HttpStatus.OK);

        } catch( RecursoNoEncontradoExcep e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
