package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.UsuarioModel;

import java.util.List;

public interface IUsuarioService {
    public String crearUsuario(UsuarioModel usuario);
    public List<UsuarioModel> obtenerUsuarios();
}
