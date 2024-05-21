package com.apiweb.backendproyecto.Controller;

import com.apiweb.backendproyecto.Exception.RecursoNoEncontradoExcep;
import com.apiweb.backendproyecto.Model.ReciboModel;
import com.apiweb.backendproyecto.Service.IReciboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/apirest/recibos")
public class ReciboController {

    @Autowired
    IReciboService reciboService;


}
