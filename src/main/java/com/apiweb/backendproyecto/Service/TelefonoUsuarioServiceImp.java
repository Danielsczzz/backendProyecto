package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.TelefonoUsuarioModel;
import com.apiweb.backendproyecto.Model.UsuarioModel;
import com.apiweb.backendproyecto.Repository.ITelefonoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefonoUsuarioServiceImp implements ITelefonoUsuarioService {
    @Autowired ITelefonoUsuarioRepository telefonoUsuarioRepository;

    @Override
    public String crearTelefonoUsuario(TelefonoUsuarioModel telefonoUsuario) {
        telefonoUsuarioRepository.save(telefonoUsuario);
        return String.format("El telefono %s ha sido agregado correctamente", telefonoUsuario.getTelefono());
    }

    @Override
    public List<TelefonoUsuarioModel> obtenerTelefonosDeUsuario(UsuarioModel usuario) {
        return telefonoUsuarioRepository.findAllByIdUsuario(usuario);
    }
}
