package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.UnidadModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUnidadRepository extends JpaRepository<UnidadModel, Integer> {
}
