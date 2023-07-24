package com.prueba.app.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.app.model.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByIdentificacion(int identificacion);
    
    void deleteByIdentificacion(int identificacion);

}
