package com.prueba.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.app.model.entities.Factura;
import com.prueba.app.model.entities.Persona;
import com.prueba.app.model.service.DirectorioServiceImpl;
import com.prueba.app.model.service.VentasServiceImpl;

@RestController
@RequestMapping("/api")
public class VentasController {

    @Autowired
    private VentasServiceImpl VentasServiceImpl;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/agregar-factura")
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {

        Factura facturaGuardada = VentasServiceImpl.storeFactura(factura);

        if (facturaGuardada != null) {
            return new ResponseEntity<>(facturaGuardada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/facturas/{id}")
    public ResponseEntity<Persona> obtenerFacturasPorPersonaId(@PathVariable int id) {
        Persona facturas = VentasServiceImpl.findFacturaByPersona(id);
        if (facturas != null) {
            return new ResponseEntity<>(facturas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
