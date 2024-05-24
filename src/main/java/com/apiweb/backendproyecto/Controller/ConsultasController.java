package com.apiweb.backendproyecto.Controller;

import com.apiweb.backendproyecto.DTO.ReporteUsuarioDTO;
import com.apiweb.backendproyecto.Exception.RecursoNoEncontradoExcep;
import com.apiweb.backendproyecto.Model.UsuarioModel;
import com.apiweb.backendproyecto.Service.IConsultasService;
import com.apiweb.backendproyecto.Service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/apirest/consultas")
@RestController
public class ConsultasController {

    @Autowired IConsultasService consultasService;
    @Autowired IUsuarioService usuarioService;

    /**
     * Devuelve el reporte de un usuario y sus solicitudes.
     *
     * @param id Recibe el id del usuario a hacer el reporte.
     * @return Retorna una instancia de ReporteUsuarioDTO (nombreUsuario, correo, profesion, cantidadSoliciutes, DineroFacturado)
     */
    @GetMapping("/reporte/usuarios/{id}")
    public ResponseEntity<?> obtenerReporteUsuario(@PathVariable int id) {
        try {
            UsuarioModel usuario = usuarioService.obtenerUsuarioPorId(id);

            if(usuario == null) {
                throw new RecursoNoEncontradoExcep("no se encontro un usuario con el id " + id);
            }

            // trae la informacion del usuario
            List<Object[]> infoUsuarioData = consultasService.infoUsuario(id);
            Object[] infoObject = infoUsuarioData.getFirst();
            List<String> infoUsuario = new ArrayList<>();
            for(int i = 0; i < infoObject.length; i++) {
                infoUsuario.add(String.valueOf(infoObject[i]));
            }

            // llama las otras dos consultas y las castea a String
            String cantidadSolicitudes = String.valueOf(consultasService.cantidadSolicitudesDeUsuario(id));
            String dineroFacturado = String.valueOf(consultasService.cantidadDineroFacturadoDeUsuario(id));

            // crea una instancia de reporteDTO y setea los valores obtenidos en las consultas
            ReporteUsuarioDTO reporte = new ReporteUsuarioDTO();

            reporte.setNombre(infoUsuario.getFirst());
            reporte.setCorreo(infoUsuario.get(1));
            reporte.setProfesion(infoUsuario.getLast());
            reporte.setCantidadSolicitudes(cantidadSolicitudes);
            reporte.setDineroFacturado(dineroFacturado);

            return new ResponseEntity<>(reporte, HttpStatus.OK);

        } catch( RecursoNoEncontradoExcep e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
