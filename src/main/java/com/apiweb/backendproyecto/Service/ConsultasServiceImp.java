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
    public List<Object[]> reporteUsuario(int idUsuario) {
        List<Object[]> reporteUsuario = new ArrayList<>();
        reporteUsuario.add(usuarioRepository.infoUsuario(idUsuario));
        reporteUsuario.add(usuarioRepository.cantidadSolicitudesDeUsuario(idUsuario));
        reporteUsuario.add(usuarioRepository.cantidadFacturadoDeUsuario(idUsuario));
        return reporteUsuario;
    }
}
