package com.prueba.app.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.app.model.entities.Factura;
import com.prueba.app.model.entities.Persona;


public interface IVentasService {

    Persona findFacturaByPersona(Integer id);
    Factura storeFactura(Factura factura);
    
}
