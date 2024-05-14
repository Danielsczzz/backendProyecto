package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.TipoTramiteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoTramiteRepository extends JpaRepository<TipoTramiteModel, Integer> {
}
