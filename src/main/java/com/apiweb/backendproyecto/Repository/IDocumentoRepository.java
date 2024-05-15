package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.DocumentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentoRepository extends JpaRepository<DocumentoModel, Integer> {
}
