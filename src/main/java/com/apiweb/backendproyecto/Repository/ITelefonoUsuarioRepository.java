package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.TelefonoUsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITelefonoUsuarioRepository extends JpaRepository<TelefonoUsuarioModel, Integer> {
}
