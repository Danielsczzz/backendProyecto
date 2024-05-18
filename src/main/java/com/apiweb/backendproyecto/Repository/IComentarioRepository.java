package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.ComentarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComentarioRepository extends JpaRepository<ComentarioModel, Integer> {
}
