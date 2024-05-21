package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.DocumentoModel;
import com.apiweb.backendproyecto.Model.TramiteModel;

import java.util.List;

public interface IDocumentoService {
    List<DocumentoModel> obtenerDocumentos();
    String crearDocumento(DocumentoModel documento);
    List<DocumentoModel> obtenerDocumentosDeTramite(TramiteModel tramiteModel);
}
