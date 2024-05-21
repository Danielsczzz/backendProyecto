package com.apiweb.backendproyecto.Controller;

import com.apiweb.backendproyecto.DTO.UnidadDTO;
import com.apiweb.backendproyecto.Exception.RecursoNoEncontradoExcep;
import com.apiweb.backendproyecto.Model.TelefonoUnidadModel;
import com.apiweb.backendproyecto.Model.UnidadModel;
import com.apiweb.backendproyecto.Service.ITelefonoUnidadService;
import com.apiweb.backendproyecto.Service.IUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apirest/unidades")
public class UnidadController {

    @Autowired IUnidadService unidadService;
    @Autowired ITelefonoUnidadService telefonoUnidadService;

    @GetMapping("/")
    public ResponseEntity<List<UnidadModel>> obtenerUsuarios(){
        return new ResponseEntity<>(unidadService.obtenerUnidades(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> crearUnidad(@RequestBody UnidadDTO unidadDTO) {
        if (unidadDTO == null) {
            return new ResponseEntity<String>("Tiene que ingresar una unidad para continuar", HttpStatus.BAD_REQUEST);
        }
        UnidadModel unidad = new UnidadModel();
        unidad.setNombre(unidadDTO.getNombre());
        String respuestaUnidad = unidadService.crearUnidad(unidad);
        StringBuilder respuestaTelefonos = new StringBuilder();
        List<Map<String, String>> infoTelefonos = unidadDTO.getTelefonos();
        if (infoTelefonos == null) {
            return new ResponseEntity<String>(String.format("%s \nNo se brindo informacion de los telefonos", respuestaUnidad), HttpStatus.OK);
        }
        for (Map<String, String> data : infoTelefonos) {
            TelefonoUnidadModel telefono = new TelefonoUnidadModel();
            telefono.setTelefono(data.get("telefono"));
            telefono.setIdUnidad(unidad);
            String respuestaTelefono = telefonoUnidadService.crearTelefonoUnidad(telefono);
            respuestaTelefonos.append(respuestaTelefono);
            respuestaTelefonos.append("\n");
        }
        String respuestaFinal = String.format("%s \n%s", respuestaUnidad, respuestaTelefonos.toString());
        return new ResponseEntity<String>(respuestaFinal, HttpStatus.OK);
    }

    @GetMapping("/masLucrativa")
    public ResponseEntity<List<Map<String, Double>>> obtenerUnidadMasLucrativa(){
        return new ResponseEntity<>(unidadService.obtenerUnidadMasLucrativa(), HttpStatus.OK);
    }

    @GetMapping("/{id}/telefonos")
    public ResponseEntity<?> obtenerUnidadTelefonos(@PathVariable int id){
        try {
            UnidadModel unidad = unidadService.obtenerUnidadPorId(id);
            if (unidad == null) {
                throw new RecursoNoEncontradoExcep("No existe una unidad con el id " + id);
            }
            return new ResponseEntity<>(telefonoUnidadService.obtenerTelefonosDeUnidad(unidad), HttpStatus.OK);
        } catch(RecursoNoEncontradoExcep e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
