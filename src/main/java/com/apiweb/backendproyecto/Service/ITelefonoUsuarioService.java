package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.TelefonoUsuarioModel;

import java.util.List;

public interface ITelefonoUsuarioService {
    List<TelefonoUsuarioModel> obtenerTelefonoUsuario();
    String crearTelefonoUsuario(TelefonoUsuarioModel telefonoUsuario);
}
