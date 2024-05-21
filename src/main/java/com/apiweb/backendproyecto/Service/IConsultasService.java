package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.UsuarioModel;

import java.util.List;

public interface IConsultasService {
    List<Object[]> reporteUsuario(int idUsuario);
}
