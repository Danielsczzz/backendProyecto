package com.apiweb.backendproyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apiweb.backendproyecto.Model.UsuarioModel;

public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
}
