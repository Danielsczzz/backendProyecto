package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.TelefonoUnidadModel;
import com.apiweb.backendproyecto.Model.UnidadModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITelefonoUnidadRepository extends JpaRepository<TelefonoUnidadModel, String> {
    List<TelefonoUnidadModel> findAllByIdUnidad(UnidadModel unidad);
}
