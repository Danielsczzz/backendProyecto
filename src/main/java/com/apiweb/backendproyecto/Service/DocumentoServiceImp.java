package com.apiweb.backendproyecto.Service;

import com.apiweb.backendproyecto.Model.DocumentoModel;
import com.apiweb.backendproyecto.Repository.IDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoServiceImp implements IDocumentoService {
    @Autowired IDocumentoRepository documentoRepository;

    @Override
    public List<DocumentoModel> obtenerDocumentos() {
        return documentoRepository.findAll();
    }

    @Override
    public String crearDocumento(DocumentoModel documento) {
        documentoRepository.save(documento);
        return String.format("El documento %s ha sido creado correctamente", documento.getArchivoURL());
    }
}
