package com.apiweb.backendproyecto.Controller;

import com.apiweb.backendproyecto.DTO.UsuarioDTO;
import com.apiweb.backendproyecto.Model.TelefonoUsuarioModel;
import com.apiweb.backendproyecto.Model.UsuarioModel;
import com.apiweb.backendproyecto.Service.ITelefonoUsuarioService;
import com.apiweb.backendproyecto.Service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apirest/usuarios")
public class UsuarioController {
    @Autowired IUsuarioService usuarioService;
    @Autowired ITelefonoUsuarioService telefonoUsuarioService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            return new ResponseEntity<String>("Tiene que ingresar un usuario para continuar", HttpStatus.BAD_REQUEST);
        }
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setProfesion(usuarioDTO.getProfesion());
        String respuestaUsuario = usuarioService.crearUsuario(usuario);
        StringBuilder respuestaTelefonos = new StringBuilder();
        List<Map<String, String>> infoTelefonos = usuarioDTO.getTelefonos();
        if (infoTelefonos == null) {
            return new ResponseEntity<String>(String.format("%s \nNo se brindo informacion de los telefonos", respuestaUsuario), HttpStatus.OK);
        }
        for (Map<String, String> data : infoTelefonos) {
            TelefonoUsuarioModel telefono = new TelefonoUsuarioModel();
            telefono.setTelefono(data.get("telefono"));
            telefono.setIdUsuario(usuario);
            String respuestaTelefono = telefonoUsuarioService.crearTelefonoUsuario(telefono);
            respuestaTelefonos.append(respuestaTelefono);
            respuestaTelefonos.append("\n");
        }
        String respuestaFinal = String.format("%s \n%s", respuestaUsuario, respuestaTelefonos.toString());
        return new ResponseEntity<String>(respuestaFinal, HttpStatus.OK);

    }
}
