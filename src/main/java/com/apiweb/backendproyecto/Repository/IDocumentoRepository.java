package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.DocumentoModel;
import com.apiweb.backendproyecto.Model.TramiteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDocumentoRepository extends JpaRepository<DocumentoModel, Integer> {
    List<DocumentoModel> findByIdTramite(TramiteModel tramite);
}
