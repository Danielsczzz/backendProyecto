package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultasServiceImp implements IConsultasService {
    @Autowired IUsuarioRepository usuarioRepository;

    @Override
    public List<Object[]> infoUsuario(int idUsuario) {
        return usuarioRepository.infoUsuario(idUsuario);
    }

    @Override
    public Object cantidadSolicitudesDeUsuario(int idUsuario) {
        return usuarioRepository.cantidadSolicitudesDeUsuario(idUsuario);
    }

    @Override
    public Object cantidadDineroFacturadoDeUsuario(int idUsuario) {
        return usuarioRepository.cantidadFacturadoDeUsuario(idUsuario);
    }

}
