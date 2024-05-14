package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.TramiteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITramiteRepository extends JpaRepository<TramiteModel, Integer> {
}
