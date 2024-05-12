package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.TelefonoUsuarioModel;

import java.util.List;

public interface ITelefonoUsuarioService {
    String crearTelefonoUsuario(TelefonoUsuarioModel telefonoUsuario);
    List<TelefonoUsuarioModel> obtenerTelefonoUsuario();
}
