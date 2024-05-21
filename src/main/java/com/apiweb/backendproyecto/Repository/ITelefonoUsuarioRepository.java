package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.TelefonoUsuarioModel;
import com.apiweb.backendproyecto.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITelefonoUsuarioRepository extends JpaRepository<TelefonoUsuarioModel, Integer> {
    List<TelefonoUsuarioModel> findAllByIdUsuario(UsuarioModel usuario);
}
