package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.SolicitudModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISolicitudRepository extends JpaRepository<SolicitudModel, Integer> {
}
