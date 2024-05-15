package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.DocumentoModel;

import java.util.List;

public interface IDocumentoService {
    List<DocumentoModel> obtenerDocumentos();
    String crearDocumento(DocumentoModel documento);
}
