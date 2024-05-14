package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Exception.RecursoNoEncontradoExcep;
import com.apiweb.backendproyecto.Model.UnidadModel;
import com.apiweb.backendproyecto.Model.UsuarioModel;
import com.apiweb.backendproyecto.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements IUsuarioService{
    @Autowired IUsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioModel> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public String crearUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
        return String.format("El usuario %s ha sido creado con exito", usuario.getNombre());
    }

    @Override
    public UsuarioModel obtenerUsuarioPorId(Integer id) {
        Optional<UsuarioModel> usuarioRecuperado = usuarioRepository.findById(id);
        return usuarioRecuperado.orElseThrow(() -> new RecursoNoEncontradoExcep(String.format("No existe un usuario con el id %d", id)));
    }
}
