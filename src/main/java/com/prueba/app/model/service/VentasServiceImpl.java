package com.prueba.app.model.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.app.model.FacturaRepository;
import com.prueba.app.model.entities.Factura;
import com.prueba.app.model.entities.Persona;

@Service
public class VentasServiceImpl implements IVentasService {

    private FacturaRepository facturaRepository;

    @Autowired
    public VentasServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }


    @Override
    @Transactional
    public Persona findFacturaByPersona(Integer id) {
        return facturaRepository.findFacturaByPersona(id);
    }

    @Transactional
    @Override
    public Factura storeFactura(Factura factura) {
        // TODO Auto-generated method stub
        return facturaRepository.save(factura);
    }



    
}
