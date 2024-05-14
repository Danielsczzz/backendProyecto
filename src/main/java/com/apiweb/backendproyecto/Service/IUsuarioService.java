package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.UsuarioModel;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioModel> obtenerUsuarios();
    String crearUsuario(UsuarioModel usuario);
    UsuarioModel obtenerUsuarioPorId(Integer id);
}
