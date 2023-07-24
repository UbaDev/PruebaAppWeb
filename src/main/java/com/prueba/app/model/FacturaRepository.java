package com.prueba.app.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prueba.app.model.entities.Factura;
import com.prueba.app.model.entities.Persona;

public interface FacturaRepository extends JpaRepository<Factura, Integer>{

    @Query("SELECT p FROM Persona p JOIN FETCH p.facturas f WHERE p.idPersona = :id")
    Persona findFacturaByPersona(@Param("id") int id);
}
